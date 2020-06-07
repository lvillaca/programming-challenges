package onscala.hackerrank.implementations

import org.scalatest.Assertions
import org.testng.Assert._
import org.testng.annotations.{DataProvider, Test}

/**
  * Site: HackerRank
  * Problem: Extra Long Factorial
  *
  * User: Luis Villaca
  * Date: 24/05/2020
  */
class ExtraLongFactorial extends Assertions {

  def extraLongFactorials(n: Int): BigInt = {
    def factorial(bi: BigInt): BigInt =
      if (3 > bi) bi
      else bi * factorial(bi - 1)

    val bigInt = BigInt(n)
    factorial(bigInt)
  }

  //Evaluating
  @DataProvider(name= "tests")
  def testData() = {
    Array(
      Array[Any](1, BigInt(1)),
      Array[Any](5, BigInt(120)),
      Array[Any](25, BigInt("15511210043330985984000000")),
      Array[Any](30, BigInt("265252859812191058636308480000000"))
    )
  }

  @Test(dataProvider = "tests")
  def verify(intInput: Int, expectedOutput: BigInt): Unit =
    assertEquals(extraLongFactorials(intInput),expectedOutput)

}
