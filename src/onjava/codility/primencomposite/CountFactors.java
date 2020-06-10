package onjava.codility.primencomposite;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Site: Codility
 * Problem: Count Factors
 *
 * User: Luis Villaca
 * Date: 01/05/2020
 */
public class CountFactors {

    public static int solution(int N) {
        int count=0;
        for (int n=1;n<=Math.sqrt(N);n++) {
            if (N%n == 0) count+=2;
            if (n==Math.sqrt(N)) count--;
        }

        return count;
    }

    @DataProvider(name = "test")
    public Object [][] createData1() {
        return new Object [][] {
                new Object [] {          24,  8 },
                new Object [] {          1,  1 },
                new Object [] {          41,  2 },
                new Object [] {          36,  9 },
                new Object [] {          16,  5 },
        };
    }

    @Test(dataProvider = "test")
    public void verifySolution(int pInput, int expectedFactors) {
        Assert.assertEquals(solution(pInput), expectedFactors);
    }
}
