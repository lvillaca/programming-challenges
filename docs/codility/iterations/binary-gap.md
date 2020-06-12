# Binary Gap: Arrays

The [Scala](../../../src/onscala/codility/iterations/BinaryGap.scala) and [Java](../../../src/onjava/codility/iterations/BinaryGap.java) source codes present the solution for [this](https://app.codility.com/programmers/lessons/1-iterations/binary_gap/) challenge.

The challenge description was not reproduced due to copyrights.

Strategy:
 - get the binary representation of the input integer on a String
 - use regular expression to replace a sequence of one or more `0s` followed by `1`  (in the beggining of the String) with a token, as `|` 
 - use regular expression to replace a sequence of one or more `0s` following a `1` (in the end of the String) with the same token above
 - replace all `1s` (left in the middle) with the token
 - tokenize the string
 - return the length of the biggest token 
  