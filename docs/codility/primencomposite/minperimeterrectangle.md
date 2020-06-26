# MinPerimeterRectangle


The [Scala](../../../src/onscala/codility/primencomposite/MinPerimeterRectangle.scala) and [Java](../../../src/onjava/codility/primencomposite/MinPerimeterRectangle.java) source codes present the solution for [this](https://app.codility.com/programmers/lessons/10-prime_and_composite_numbers/min_perimeter_rectangle/) challenge.

The challenge description was not reproduced due to copyrights.

Strategy:
 - any given number factor below square root (x) will have a factor counterpart (y) greater than its square root: 
   - `factor x * factor y = square root * square root`
 - hence, from 1 up to square root, evaluate the perimeter for each pair of factors:
   - `perimeter = 2 * (factor x + factor y)` - and keep track of the minimum factor
 - return the minimum perimeter