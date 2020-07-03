# Peaks 

The [Scala](../../../src/onscala/codility/primencomposite/Peaks.scala) and [Java](../../../src/onjava/codility/primencomposite/Peaks.java) source codes present the solution for [this](https://app.codility.com/programmers/lessons/10-prime_and_composite_numbers/peaks/) challenge.

The challenge description was not reproduced due to copyrights.

Strategy:
 - build an accumulated array from left to right indicating the number of peaks
 - for each factor of input array (to divide in blocks of equal sizes), from 1 to number of peaks found:
   - find if each array block, of length = `input array size / factor `, contain at least 1 peak
 - return the maximum factor that conforms to the check above