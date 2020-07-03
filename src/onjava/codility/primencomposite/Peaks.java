package onjava.codility.primencomposite;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


/**
 * Site: Codility
 * Problem: Peaks
 *
 * User: Luis Villaca
 * Date: 24/05/2020
 */
public class Peaks {
    public static int solution(int[] A) {
        //Peaks
        int lenghtOfA = A.length;
        int[] peaks = new int[lenghtOfA];

        if (lenghtOfA < 3) return 0;

        peaks[0] = 0;

        for (int n = 1; n < lenghtOfA - 1; n++) {
            if (A[n - 1] < A[n] && A[n] > A[n + 1]) {
                peaks[n] = peaks[n-1]+1;   // accumulating peaks
            } else {
                peaks[n] = peaks[n-1];
            }
        }


        // updating last line (not included above)
        peaks[lenghtOfA - 1] = peaks[lenghtOfA - 2];

        int nbrPeaks = peaks[lenghtOfA-1];

        if (nbrPeaks < 1) return 0;
        if (nbrPeaks == 1) return 1;

        int maxDivs = 1;

        for (int n = 1; n <= nbrPeaks; n++) {
            if (lenghtOfA % n == 0) { // divide equally

                //first block
                int blockSize = lenghtOfA / n;
                int prevBlock = 0;
                int endBlock = blockSize - 1;
                boolean terminate=false;

                while (endBlock< lenghtOfA) {
                    if (!hasPeak(prevBlock, endBlock, peaks)) {
                        terminate=true;
                        break;
                    }
                    prevBlock = endBlock + 1;
                    endBlock += blockSize;
                }

                if (terminate) {
                    continue;
                } else {
                    maxDivs= n;
                }
            }
        }

        return maxDivs;
    }

    public static boolean hasPeak(int init, int end, int[] peaks) {
        //Peaks
        if (init == 0) return peaks[end] > 0;
        else {
            return peaks[end] > peaks[init - 1];
        }
    }


    @DataProvider(name = "test")
    public Object[][] createData1() {
        return new Object[][]{
                new Object[]{new int[]{1, 2, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2}, 3},
                new Object[]{new int[]{1, 3, 2, 1}, 1},
                new Object[]{new int[]{1, 4, 1, 3, 2}, 1},
                new Object[]{new int[]{1, 2, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2, 1, 2, 5, 2}, 4},
                new Object[]{new int[]{0, 1, 0, 1, 0, 1, 0, 1}, 2},
                new Object[]{new int[]{0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1}, 4},
                new Object[]{new int[]{0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1}, 4},
                new Object[]{new int[]{0, 1, 0, 0, 0, 1, 0, 0, 1, 0, 1, 0}, 4},
                new Object[]{new int[]{0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0}, 4},
                new Object[]{new int[]{0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 1, 0, 1, 0, 0, 0}, 4},
                new Object[]{new int[]{0, 1, 0, 0, 1, 0, 0, 1, 0}, 3},
                new Object[]{new int[]{0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0}, 1},
                new Object[]{new int[]{1, 2, 3, 4, 5, 6, 5, 5, 5, 6, 5, 6}, 2},
                new Object[]{new int[]{1, 2, 1, 1, 2, 1, 1, 2, 1, 1, 2, 1, 1, 2, 1, 1, 2, 1, 1, 2, 1, 1, 2, 1, 1, 2, 1, 1, 2, 1}, 10},
                new Object[]{new int[]{5}, 0},
        };
    }

    @Test(dataProvider = "test")
    public void verifySolution(int[] pInput, int expectedCount) {
        Assert.assertEquals(solution(pInput), expectedCount);
    }
}
