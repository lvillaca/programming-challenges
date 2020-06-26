package onjava.codility.stacksnqs;


import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Stack;

/**
 * Site: HackerRank
 * Problem: Stone Wall
 *
 * User: Luis Villaca
 * Date: 24/03/2020
 */
public class StoneWall {
    public int solution(int[] H) {
        Stack<Integer> stack= new Stack<>();

        int count=0;
        int index=0;

        // loop through array elements
        while(index<H.length) {

            // descending
            while (!stack.isEmpty() && H[index] < stack.peek()) {
                stack.pop();
                //do not increment index nor counter
                //instead, remove from cache and compare with previous entry
            }

            // ascending - add block
            if (stack.isEmpty() || H[index] > stack.peek()) {
                count++;
                stack.push(H[index]);
                index++;
                continue;
            } else {
                // if (H[index] == inStack) - plateau
                // do not increment counter, nor change cache
                index++;
            }
        }
        return count;
    }


    @DataProvider(name = "test")
    public Object [][] createData1() {
        return new Object [][] {
                new Object [] { new int [] { 8, 8, 5, 7, 9, 8, 7, 4, 8 }, 7 },
                new Object [] { new int [] { 0 }, 1 },
        };  //max
    }

    @Test(dataProvider = "test")
    public void verifySolution(int [] pA, int pExpectedMinNumberBlocks) {
        int actualMinNumberBlocksA = solution(pA);
        Assert.assertEquals(pExpectedMinNumberBlocks, actualMinNumberBlocksA);
    }
}
