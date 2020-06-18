package onjava.codility.maxslice;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static java.lang.Math.max;

/**
 * Site: HackerRank
 * Problem: MaxDoubleSliceSum
 *
 * User: Luis Villaca
 * Date: 24/05/2020
 */
public class MaxDoubleSliceSum {
    public int solution(int[] A) {

        int[] partMaxSumEndingInIndexX = new int[A.length]; //1st half partial sum
        int[] partMaxSumStartingFromIndexX = new int[A.length]; // 2nd half partial sum

        partMaxSumEndingInIndexX[0] = 0;
        partMaxSumStartingFromIndexX[A.length-1] = 0;
        
        for (int index=1; index<A.length-1;index++) { // loop ignoring 1st and last elements
            int accumInit = A[index]+partMaxSumEndingInIndexX[index-1];
        partMaxSumEndingInIndexX[index] = Integer.max(accumInit,0);

        int invIndex = A.length-1-index;
        int accumEnd = A[invIndex]+partMaxSumStartingFromIndexX[invIndex+1];
        partMaxSumStartingFromIndexX[invIndex] = Integer.max(accumEnd,0);
    }

    int maxTotal=0;
        for (int middle=1; middle<A.length-1;middle++){
        int maxLeft=partMaxSumEndingInIndexX[middle-1];

        int maxRight=partMaxSumStartingFromIndexX[middle+1];
        maxTotal= max(maxTotal,maxLeft+maxRight);
    }

        return maxTotal;
    }


    @DataProvider(name = "test")
    public Object [][] createData1() {
        return new Object [][] {
                new Object [] { new int [] { 3, 2, 6, -1, 4, 5, -1, 2 }, 17 },
                new Object [] { new int [] { 5, 17, 0, 3 }, 17 },
                new Object [] { new int [] { -2 -3, 4, -1, -2, 1, 5, -3 }, 9 },
                new Object [] { new int [] { 1, 2, 3 }, 0 },
                new Object [] { new int [] { 0, 10, -5, -2, 0, 0 }, 10}

        };
    }

    @Test(dataProvider = "test")
    public void verifySolution(int [] pA, int pExpectedMaxSliceSum) {
        int actualMaxSliceSum = solution(pA);
        Assert.assertEquals(actualMaxSliceSum, pExpectedMaxSliceSum);
    }
}
