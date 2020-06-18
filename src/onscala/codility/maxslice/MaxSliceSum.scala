package onscala.codility.maxslice

import org.scalatest.Assertions
import org.testng.Assert._
import org.testng.annotations.{DataProvider, Test}

import scala.annotation.tailrec

/**
  * Site: HackerRank
  * Problem: MaxSliceSum
  *
  * User: Luis Villaca
  * Date: 24/05/2020
  */
class MaxSliceSum extends Assertions {

  def solution(a: Array[Int]): Int = {

    @tailrec
    def recursiveSliceCheck(innList: List[Int], acc: Int, maxSliceSum: Int): Int = {
      if (innList.isEmpty) maxSliceSum
      else {
        val newElement = innList.head
        val newAcc = acc + newElement

        // accumulate as long as it contributes to maxSliceSum
        if (newAcc > 0) { // will contribute to future accumulations
          if (newAcc > newElement) {
            recursiveSliceCheck(innList.tail, newAcc, Math.max(maxSliceSum, newAcc))
            // remain accumulating
          }
          else {
            // newElement is > = acc
            recursiveSliceCheck(innList.tail, newElement, Math.max(maxSliceSum, newElement))
            // newElement becomes acc
          }
        }
        else { //  accumulation became <= 0 and can be ignored (reset)
          recursiveSliceCheck(innList.tail, 0, Math.max(maxSliceSum, newElement))
        }
      }
    }

    val maxSliceSum = Integer.MIN_VALUE
    val acc = 0
    recursiveSliceCheck(a.toList, acc, maxSliceSum)
  }


  //Evaluating
  @DataProvider(name= "tests")
  def testData() = Array(
    Array[Any](Array(3, 2, -6, 4, 0), 5),
    Array[Any](Array(-1, 8), 8),
    Array[Any](Array(8, -1), 8),
    Array[Any](Array(8, -1, 7), 14),
    Array[Any](Array(-10), -10),
    Array[Any](Array(8), 8),
    Array[Any](Array(5, -15, 10, -1, 10), 19)
  )

  @Test(dataProvider = "tests")
  def verify(arrayInput: Array[Int], expectedOutput: Int): Unit = {
    val actualOutput = solution(arrayInput)
    assertEquals(actualOutput, expectedOutput)
  }

}







