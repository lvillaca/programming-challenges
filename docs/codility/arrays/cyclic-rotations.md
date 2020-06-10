# Cyclic Rotations: Arrays

The [Scala](../../../src/onscala/codility/arrays/CyclicRotations.scala) and [Java](../../../src/onjava/codility/arrays/CyclicRotations.java) source codes present the solution for [this](https://app.codility.com/programmers/lessons/2-arrays/cyclic_rotation/) challenge.



Requirements Description:

An array A consisting of N integers is given. Rotation of the array means that each element is shifted right by one index, and the last element of the array is moved to the first place. 

For example, the rotation of array 
`A = [3, 8, 9, 7, 6]` is `[6, 3, 8, 9, 7]`
(elements are shifted right by one index and 6 is moved to the first place).

The goal is to rotate array A K times; that is, each element of A will be shifted to the right K times.

Write a function:

`object Solution { def solution(a: Array[Int], k: Int): Array[Int] }`

that, given an array A consisting of N integers and an integer K, returns the array A rotated K times.

For example, given

    A = [3, 8, 9, 7, 6]
    K = 3
the function should return `[9, 7, 6, 3, 8]`

Strategy:
 - for each element, find its new index - current index + rotations;
 - if new index above exceeds array length, check where element would land within array with division remainder operator (%)