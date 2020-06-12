package onjava.codility.leader;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Optional;

/**
 * Site: Codility
 * Problem: EquiLeader
 *
 * User: Luis Villaca
 * Date: 10/04/2020
 */
public class EquiLeader {

    private static int LEFT_TO_RIGHT = 0;
    private static int RIGHT_TO_LEFT = 1;

    Optional<Integer> getLeader(int[] A) {

        Optional<Integer> leader = Optional.empty();

        // accumulated values
        HashMap<Integer, Integer> accumCountMapLTR = new HashMap();

        // define target for count (50% round down to nearest int)
        int target50percent = (A.length)/2;

        for (int i=0; i<A.length; i++) {
            int candidate = A[i];

            // count for candidate
            int accumulateCount = Optional.ofNullable(accumCountMapLTR.get(candidate)).orElse(0) + 1;

            // update candidate counter
            accumCountMapLTR.put(candidate, accumulateCount);

            // check if it's a leader ( > 50 % of occurrences) - if so, assign
            if (accumulateCount > target50percent) {
                // found the leader
                leader = Optional.of(candidate);
            }
        }
        return leader;



    }

    Boolean[] getLeaderMarks(int direction, int leader, int[] A) {

        // response data structure
        Boolean[] leaders = new Boolean[A.length];
        Arrays.fill(leaders, false);

        // accumulated values
        int accumLeaderCounter = 0;

        for (int i=0; i<A.length; i++) {
            int innerIndex = i;

            // define how to traverse based on direction
            if (direction == RIGHT_TO_LEFT) innerIndex = A.length - 1 - i;

            int element = A[innerIndex];

            // check if it's a leader if so, update counter
            if (element == leader) {
                // update count for leader
                accumLeaderCounter++;
            }

            //compare counter to # elements in sequence
            int nbrElementsInSequence = i+1;

            // inner target
            int innerTarget50percent = nbrElementsInSequence/2;

            // if it's a internal leader, mark
            if (accumLeaderCounter > innerTarget50percent) {
                leaders[innerIndex] = true;
            }

        }
        return leaders;
    }

    public int solution(int[] A) {

        int totalEquileaders = 0;

        // first check if there is a leader (otherwise there are no equileaders)
        Optional<Integer> leader = getLeader(A);

        if (leader.isPresent()) {
            Boolean[] leadersLeftToRight = getLeaderMarks(LEFT_TO_RIGHT, leader.get(), A);

            Boolean[] leadRightToLeft = getLeaderMarks(RIGHT_TO_LEFT, leader.get(), A);

            for (int k = 0; k < leadersLeftToRight.length-1; k++) {
                if (leadersLeftToRight[k] && leadRightToLeft[k+1]) {
                    totalEquileaders++;
                }
            }

        }

        return totalEquileaders;
    }


    @DataProvider(name = "test")
    public Object [][] createData1() {
        return new Object [][] {
                new Object [] { new int [] { 4,3,4,4,4,2 },  2 },
                new Object [] { new int [] { 4, 4, 2, 5, 3, 4, 4, 4},  3 },
                new Object [] { new int [] { 1, 2, 1, 1, 2, 1},  3 },
                new Object [] { new int [] { 4,4 },  1 }
        };
    }

    @Test(dataProvider = "test")
    public void verifySolution(int[] pInput, int expectedCount) {
        Assert.assertEquals(solution(pInput), expectedCount);
    }
}
