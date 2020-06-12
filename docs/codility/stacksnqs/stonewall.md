# StoneWall

The [Scala](../../../src/onscala/codility/stacksnqs/StoneWall.scala) and [Java](../../../src/onjava/codility/stacksnqs/StoneWall.java) source codes present the solution for [this](https://app.codility.com/programmers/lessons/7-stacks_and_queues/stone_wall/) challenge.

The challenge description was not reproduced due to copyrights.

Strategy:

 - Loop through array elements, tracking previous positions in memory and:
   - if the last cached position is higher than the current one (descending):
     - while new position is less than the last cached entry, iteratively compare it with previous cached entries, until we find a position (previous block) lower or at the same level as it
   - after previous this processing, cache may be empty, or current cached entry is higher or equal to new high position
   - if it is higher, increment counter (new block) and add new position to cache
   - if it is equal, we have a plateau - continue analysis (no new block, and no need for a cache update)
