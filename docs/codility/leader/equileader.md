# Binary Gap: Arrays

The [Scala](../../../src/onscala/codility/leader/EquiLeader.scala) and [Java](../../../src/onjava/codility/leader/EquiLeader.java) source codes present the solution for [this](https://app.codility.com/programmers/lessons/8-leader/equi_leader/) challenge.

The challenge description was not reproduced due to copyrights.

Strategy:
 - we can observe that if there is no leader for the sequence there will be no equi leaders
   - example, if the 1st element is the leader it needs to be present in 50% of remaining occurrences.
   
 - find the total leader 
 - if there is no leader, return 0
 - Otherwise
   - for each incremental substring from left to right (LTR), mark with T/F the places the total leader appears as inner leader
     - For the Codility example [here](https://app.codility.com/programmers/lessons/8-leader/equi_leader/), LTR = T F T T T T
   - for each incremental substring from right to left (RTL), mark with T/F the places the total leader appears as inner leader
     - For the Codility example [here](https://app.codility.com/programmers/lessons/8-leader/equi_leader/), we would have T T T T F F
 - count the number of cases where the LTR on index i (subarray where index <=i) matches RTL on index i+1 (subarray where index > i)
 - this count represent cases where the leader appears on both sides (equi leader)
  