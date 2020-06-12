# Cyclic Rotations

The [Scala](../../../src/onscala/codility/arrays/CyclicRotations.scala) and [Java](../../../src/onjava/codility/arrays/CyclicRotations.java) source codes present the solution for [this](https://app.codility.com/programmers/lessons/2-arrays/cyclic_rotation/) challenge.

The challenge description was not reproduced due to copyrights.

Strategy:
 - for each element, find its new index - current index + rotations;
 - if new index above exceeds array length, check where element would land within array with division remainder operator (%)