package onjava.codility.maxslice;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Site: HackerRank
 * Problem: MaxSliceSum
 *
 * User: Luis Villaca
 * Date: 24/05/2020
 */
public class MaxSliceSum {
    public int solution(int[] A) {

            int maxSliceSum = Integer.MIN_VALUE;
            int acc = 0;

            for (int i=0; i<A.length;i++) {
                int newElement = A[i];
                int newAcc = acc+newElement;

                // accumulate as long as it contributes to maxSliceSum
                if (newAcc >  0) { // will contribute to future accumulation
                    if (newAcc > newElement) {
                        maxSliceSum = Math.max(maxSliceSum, newAcc);
                        // remain accumulating
                        acc = newAcc;
                    }
                    else {
                        maxSliceSum = Math.max(maxSliceSum, newElement);
                        // newElement becomes acc
                        acc = newElement;
                    }
                }
                else {
                    //  accumulation became <= 0 and can be ignored (reset)
                    maxSliceSum = Math.max(maxSliceSum, newElement);
                    acc = 0;
                }
            }

            return maxSliceSum;
    }


    @DataProvider(name = "test")
    public Object [][] createData1() {
        return new Object [][] {
                new Object [] { new int [] { 3, 2, -6, 4, 0 }, 5 },
                new Object [] { new int [] { -1, 8 },  8},
                new Object [] { new int [] { 8, -1 },  8},
                new Object [] { new int [] { 8, -1, 7 },  14},
                new Object [] { new int [] { -8, 1, 7 },  8},
                new Object [] { new int [] { -10 },  -10},
                new Object [] { new int [] { 8 },  8},
                new Object [] { new int [] { 5, -15, 10, -1, 10 },  19},
        };  //max
    }

    @Test(dataProvider = "test")
    public void verifySolution(int [] pA, int pExpectedMaxSliceSum) {
        int actualMaxSliceSum = solution(pA);
        Assert.assertEquals(actualMaxSliceSum, pExpectedMaxSliceSum);
    }
}
