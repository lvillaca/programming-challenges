package onscala.codility.primencomposite

import org.scalatest.Assertions
import org.testng.Assert.assertEquals
import org.testng.annotations.{DataProvider, Test}

/**
  * Project: scala_challenges
  * Package: onscala.codility.primencomposite
  *
  * User: luisvillaca
  * Date: 25/06/20
  * Time: 23:26
  */
class MinPerimeterRectangle extends Assertions {

  def solution(n: Int): Int = {
    val sqrtOfN = math.sqrt(n)
    // check if it's a factor - if so, calculate perimeter and fetch the minimum value
    (1 to sqrtOfN.toInt).filter(n % _ == 0)
      .map( factor => 2.toLong * (factor + (n/factor))).min.toInt
    // cast (toLong) to avoid possible overflow
    // cast back to int to respond
  }

  //Evaluating
  @DataProvider(name= "tests")
  def testData() = {
    Array(
      Array[Any](30, 22)
    )
  }

  @Test(dataProvider = "tests")
  def verify(intInput: Int, expectedOutput: Int): Unit = {
    val actualOutput = solution(intInput)
    assertEquals(actualOutput, expectedOutput)
  }

}
