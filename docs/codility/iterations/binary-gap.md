# Binary Gap: Arrays

The [Scala](../../../src/onscala/codility/iterations/BinaryGap.scala) and [Java](../../../src/onjava/codility/iterations/BinaryGap.java) source codes present the solution for [this](https://app.codility.com/programmers/lessons/1-iterations/binary_gap/) challenge.



Requirements Description:

A _binary gap_ within a positive integer N is any maximal sequence of consecutive zeros that is surrounded by ones at both ends in the binary representation of N.

For example, number 9 has binary representation 1001 and contains a binary gap of length 2. The number 529 has binary representation 1000010001 and contains two binary gaps: one of length 4 and one of length 3. The number 20 has binary representation 10100 and contains one binary gap of length 1. The number 15 has binary representation 1111 and has no binary gaps. The number 32 has binary representation 100000 and has no binary gaps.
Write a function:

`class Solution { public int solution(int N); }`

that, given a positive integer N, returns the length of its longest binary gap. The function should return 0 if N doesn't contain a binary gap.

For example, given N = 1041 the function should return 5, because N has binary representation 10000010001 and so its longest binary gap is of length 5. 

Given N = 32 the function should return 0, because N has binary representation '100000' and thus no binary gaps.

Strategy:
 - get the binary representation of the input integer on a String
 - use regular expression to replace a sequence of one or more `0s` followed by `1`  (in the beggining of the String) with a token, as `|` 
 - use regular expression to replace a sequence of one or more `0s` following a `1` (in the end of the String) with the same token above
 - replace all `1s` (left in the middle) with the token
 - tokenize the string
 - return the length of the biggest token 
  