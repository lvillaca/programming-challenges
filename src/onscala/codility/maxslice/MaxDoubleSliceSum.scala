package onscala.codility.maxslice

import org.scalatest.Assertions
import org.testng.Assert._
import org.testng.annotations.{DataProvider, Test}

import scala.annotation.tailrec

/**
  * Site: HackerRank
  * Problem: MaxDoubleSliceSum
  *
  * User: Luis Villaca
  * Date: 24/05/2020
  */
class MaxDoubleSliceSum extends Assertions {

  def solution(a: Array[Int]): Int = {

    val partMaxSumEndingInIndexX = new Array[Int](a.length)
    //1st half partial sum
    val partMaxSumStartingFromIndexX = new Array[Int](a.length) // 2nd half partial sum

    partMaxSumEndingInIndexX(0) = 0
    partMaxSumStartingFromIndexX(a.length - 1) = 0

    (1 until a.length - 1).foreach( index => {
      val accumInit = a(index) + partMaxSumEndingInIndexX(index - 1)
      partMaxSumEndingInIndexX(index) = Integer.max(accumInit, 0)

      val invertedIndex = a.length - 1 - index
      val accumEnd = a(invertedIndex) + partMaxSumStartingFromIndexX(invertedIndex + 1)
      partMaxSumStartingFromIndexX(invertedIndex) = Integer.max(accumEnd, 0)
    })

    (1 until a.length - 1).map( index =>
      // map to sum
      partMaxSumEndingInIndexX(index-1) + partMaxSumStartingFromIndexX(index+1)).max

  }


  //Evaluating
  @DataProvider(name= "tests")
  def testData() = Array(
    Array[Any](Array(3, 2, 6, -1, 4, 5, -1, 2), 17),
    Array[Any](Array(5, 17, 0, 3), 17),
    Array[Any](Array(-2 - 3, 4, -1, -2, 1, 5, -3), 9),
    Array[Any](Array(1, 2, 3), 0),
    Array[Any](Array(0, 10, -5, -2, 0, 0), 10)
  )

  @Test(dataProvider = "tests")
  def verify(arrayInput: Array[Int], expectedOutput: Int): Unit = {
    val actualOutput = solution(arrayInput)
    assertEquals(actualOutput, expectedOutput)
  }

}







