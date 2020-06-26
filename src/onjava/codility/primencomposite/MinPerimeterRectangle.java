package onjava.codility.primencomposite;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Site: Codility
 * Problem: MinPerimeterRectangle
 *
 * User: Luis Villaca
 * Date: 01/05/2020
 */
public class MinPerimeterRectangle {
    public static int solution(int N) {
        //MinPerimeterRectangle
        int minPer=Integer.MAX_VALUE;

        for (int n=1;n<=Math.sqrt(N);n++) {
            if (N%n == 0) {
                int other = N/n;
                minPer = (int)Math.min((2*((long)n+other)),minPer); // cast for possible overflows
            }
        }

        return minPer;
    }

    @DataProvider(name = "test")
    public Object [][] createData1() {
        return new Object [][] {
                new Object [] {30, 22},
        };
    }

    @Test(dataProvider = "test")
    public void verifySolution(int pInput, int expectedFactors) {
        Assert.assertEquals(solution(pInput), expectedFactors);
    }
}
