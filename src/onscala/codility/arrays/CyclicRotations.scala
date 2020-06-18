package onscala.codility.arrays

import org.scalatest.Assertions
import org.testng.Assert._
import org.testng.annotations.{DataProvider, Test}

/**
  * Site: Codility
  * Problem: Cyclic Rotations
  *
  * User: Luis Villaca
  * Date: 24/05/2020
  */
class CyclicRotations extends Assertions {

  def solution(a: Array[Int], k: Int): Array[Int] = {
      if (a.isEmpty) a
      else {
        val rotations = k % a.length
        val intNewArray = Array.fill(a.length)(0)

        // calculate the new index for this element
        intNewArray.indices.foreach(ind => {
          val newIndex = (ind + rotations) % a.length
          intNewArray(newIndex) = a(ind)
        })
        intNewArray
      }
    }

  //Evaluating
  @DataProvider(name= "tests")
  def testData() = {
    Array(
      Array[Any](Array(3, 8, 9,  7, 6), 3, Array(9, 7, 6,  3, 8)),
      Array[Any](Array(0,  0, 0), 1, Array(0,  0, 0)),
      Array[Any](Array(1, 2,  3, 4), 4, Array(1, 2,  3, 4)),
      Array[Any](Array(1, 2,  3, 4), 5, Array(4, 1,  2, 3)),
      Array[Any](Array(-1, 2, -3, 4), 10, Array(-3, 4, -1, 2)),
      Array[Any](Array(-1, 2, -3, 4), 99, Array(2, -3, 4, -1)),
      Array[Any](Array(-1, 2, -3, 4), 100, Array(-1, 2, -3, 4))
    )
  }

  @Test(dataProvider = "tests")
  def verify(arrayInput: Array[Int], intInput: Int, expectedOutput: Array[Int]): Unit = {
    val actualOutput = solution(arrayInput, intInput)
    assertEquals(actualOutput.length, arrayInput.length)
    actualOutput.indices.foreach(ind =>
      assertEquals(actualOutput(ind), expectedOutput(ind))
    )
  }

}







