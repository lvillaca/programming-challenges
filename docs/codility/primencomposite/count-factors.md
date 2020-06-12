# Count Factors

The [Scala](../../../src/onscala/codility/primencomposite/CountFactors.scala) and [Java](../../../src/onjava/codility/primencomposite/CountFactors.scala) source codes present the solution for [this](https://app.codility.com/programmers/lessons/10-prime_and_composite_numbers/count_factors/) challenge.

The challenge description was not reproduced due to copyrights.

Strategy:
 - any given number factor below square root will have a counterpart greater than its square root: 
   - `factor x * factor y = square root * square root`
 - consider square root once as a factor if it is an integer;
 - thus, evaluate each integer up to square root as above;
 