package onjava.codility.arrays;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Site: Codility
 * Problem: Cyclic Rotations
 *
 * User: Luis Villaca
 * Date: 20/04/2020
 */
public class CyclicRotations {
    public int[] solution(int[] A, int N) {
        //CyclicRotation

        int rotations = N%A.length;

        int[] intNewArray = new int[A.length];

        // calculate the new index for this element
        for (int i=0; i<A.length;i++) {
            int newIndex = (i + rotations) % A.length;
            intNewArray[newIndex]=A[i];
        }
        return intNewArray;
    }


    @DataProvider(name = "tests")
    public Object [][] testData() {
        return new Object [][] {
                new Object [] { new int [] { 3, 8, 9,  7, 6 },  3,  new int [] {  9, 7, 6,  3, 8 } },
                new Object [] { new int [] {       0,  0, 0 },  1,  new int [] {        0,  0, 0 } },
                new Object [] { new int [] {    1, 2,  3, 4 },  4,  new int [] {     1, 2,  3, 4 } },
                new Object [] { new int [] {    1, 2,  3, 4 },  5,  new int [] {     4, 1,  2, 3 } },
                new Object [] { new int [] {   -1, 2, -3, 4 }, 10,  new int [] {    -3, 4, -1, 2 } },
                new Object [] { new int [] {   -1, 2, -3, 4 }, 99,  new int [] {    2, -3, 4, -1 } },
                new Object [] { new int [] {   -1, 2, -3, 4 }, 100,  new int [] {   -1, 2, -3, 4 } },
        };
    }

    @Test(dataProvider = "tests")
    public void verify(int [] pA, int pK, int [] pExpectedRotatedA) {
        int [] actualRotatedA = solution(pA, pK);
        Assert.assertEquals(actualRotatedA.length, pExpectedRotatedA.length);
        for(int i=0; i<pExpectedRotatedA.length; i++) {
            Assert.assertEquals(actualRotatedA[i], pExpectedRotatedA[i]);
        }
    }
}
