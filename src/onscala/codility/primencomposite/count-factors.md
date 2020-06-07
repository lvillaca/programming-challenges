# Count Factors

The Java source code [here](CountFactors.scala) presents the solution for [this](https://app.codility.com/programmers/lessons/10-prime_and_composite_numbers/count_factors/) challenge.



Requirements Description:

A positive integer D is a factor of a positive integer N if there exists an integer M such that N = D * M.

For example, 6 is a factor of 24, because M = 4 satisfies the above condition `(24 = 6 * 4)`.

Write a function:

`object Solution { def solution(n: Int): Int }`

that, given a positive integer N, returns the number of its factors.

For example, given N = 24, the function should return 8, because 24 has 8 factors, namely 1, 2, 3, 4, 6, 8, 12, 24. There are no other factors of 24.