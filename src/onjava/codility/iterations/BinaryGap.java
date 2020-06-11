package onjava.codility.iterations;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.StringTokenizer;

/**
 * Site: Codility
 * Problem: Binary Gap
 *
 * User: Luis Villaca
 * Date: 10/04/2020
 */
public class BinaryGap {
    public static int solution(int N) {

        if (N==0) return 0;
        int maxToken = 0;

        String binary = Integer.toBinaryString(N);

        // initial token 00...01|middle|last
        binary = binary.replaceFirst("^0+1","|");
        // final token   |middle|10...0
        binary = binary.replaceFirst("10+$","|");
        // middle token  |...0..1..0..1..|
        binary = binary.replaceAll("1","|");


        //token counts
        StringTokenizer st = new StringTokenizer(binary,"|");
        while (st.hasMoreTokens()) {
            String token = st.nextToken();
            if (maxToken<token.length()) {
                maxToken = token.length();
            }
        }
        return maxToken;
    }

    @DataProvider(name = "test")
    public Object [][] createData1() {
        return new Object [][] {
                new Object [] {          0,  0 },
                new Object [] {          1,  0 },
                new Object [] {          9,  2 },
                new Object [] {         15,  0 },
                new Object [] {         32,  0 },
                new Object [] {        529,  4 },
                new Object [] {       1041,  5 },
                new Object [] {      65536,  0 },
                new Object [] {      65537, 15 },
                new Object [] {     100000,  4 },
                new Object [] {    2147483,  5 },
                new Object [] { 2147483637,  1 }, //max - 10
                new Object [] { 2147483646,  0 }, //max - 1
                new Object [] { 2147483647,  0 }  //max
        };
    }

    @Test(dataProvider = "test")
    public void verifySolution(int pInput, int expectedBinaryGap) {
        Assert.assertEquals(solution(pInput), expectedBinaryGap);
    }
}
