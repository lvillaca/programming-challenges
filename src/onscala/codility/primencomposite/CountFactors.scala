package onscala.codility.primencomposite

import org.scalatest.Assertions
import org.testng.Assert._
import org.testng.annotations.{DataProvider, Test}

/**
  * Site: HackerRank
  * Problem: Cyclic Rotations
  *
  * User: Luis Villaca
  * Date: 24/05/2020
  */
class CountFactors extends Assertions {

  def solution(n: Int): Int = {
    val sqrtOfN = math.sqrt(n)
    // count all factors twice, 1 below square root and one above it
    val count: Int = (1 to sqrtOfN.toInt).filter(n % _ == 0).map( _ => 2).sum
    if (sqrtOfN.isValidInt) count - 1 // has an exact square root
    else count
  }

  //Evaluating
  @DataProvider(name= "tests")
  def testData() = {
    Array(
      Array[Any](24, 8),
      Array[Any](1, 1),
      Array[Any](41, 2),
      Array[Any](36, 9),
      Array[Any](16, 5)
    )
  }

  @Test(dataProvider = "tests")
  def verify(intInput: Int, expectedOutput: Int): Unit = {
    val actualOutput = solution(intInput)
    assertEquals(actualOutput, expectedOutput)
  }

}







