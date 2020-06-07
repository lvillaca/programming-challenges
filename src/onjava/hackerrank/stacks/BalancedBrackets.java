package onjava.hackerrank.stacks;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Site: HackerRank
 * Problem: Balanced Brackets
 *
 * User: Luis Villaca
 * Date: 26/04/2020
 */
public class BalancedBrackets {

    public static final String YES = "YES";
    public static final String NO = "NO";

    static String isBalanced(String s) {
        //Brackets properly nested

        Pattern pRound = Pattern.compile("\\(\\)");
        Pattern pCurly = Pattern.compile("\\{\\}");
        Pattern pSquare = Pattern.compile("\\[\\]");

        while (!s.equals("")) {
            String prev = s;
            Matcher matcher = pRound.matcher(s);
            s = matcher.replaceAll("");
            matcher = pCurly.matcher(s);
            s = matcher.replaceAll("");
            matcher = pSquare.matcher(s);
            s = matcher.replaceAll("");
            if (prev.equals(s)) return NO;
        }
        return YES;
    }


    @DataProvider(name = "tests")
    public Object [][] testData() {
        return new Object [][] {
                new Object [] {"[{()}]{}", YES},
                new Object [] {"{[{()}]}", YES},
                new Object [] {"(){}[[]", NO},
                new Object [] {"())({}", NO},
                new Object [] {"{(([])[])[]}[]", YES},
                new Object [] {"{(([])[])[]]}", NO}
        };
    }

    @Test(dataProvider = "tests")
    public void verify(String sInput, String sExpected) {
        String actualOutput = isBalanced(sInput);
        Assert.assertEquals(actualOutput, sExpected);
    }
}
