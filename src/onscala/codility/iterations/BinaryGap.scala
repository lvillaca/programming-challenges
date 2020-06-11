package onscala.codility.iterations

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
class BinaryGap extends Assertions {

  def solution(n: Int): Int = {
    if (n==0)  0
    else {
      val token = "|"
      val tokenRegex = """\|""" // to split

      // for initial token 00...01|middle|last
      val patternInit = "^(0+)(1)" // one or more 0s followed by 1

      // for final token   |middle|10...0
      val patternEnd = "(1)(0+)$" // 1 followed by one or more 0s

      // for middle tokens  |...0..1..0..1..|
      val patternMiddle = "1"

      val binaryString = n.toBinaryString

      val tokenizedString = binaryString.replaceFirst(patternInit,token).replaceFirst(patternEnd,token)
        .replaceAll(patternMiddle,token)

      tokenizedString.split(tokenRegex).map(_.length)    // map to token length
        .reduceOption(_ max _).getOrElse(0)   // dealing with max if output from map is empty
    }

  }

  //Evaluating
  @DataProvider(name= "tests")
  def testData() = {
    Array(
      Array[Any](          0,  0 ),
      Array[Any](          1,  0 ),
      Array[Any](          9,  2 ),
      Array[Any](         15,  0 ),
      Array[Any](         32,  0 ),
      Array[Any](        529,  4 ),
      Array[Any](       1041,  5 ),
      Array[Any](      65536,  0 ),
      Array[Any](      65537, 15 ),
      Array[Any](     100000,  4 ),
      Array[Any](    2147483,  5 ),
      Array[Any]( 2147483637,  1 ), //max - 10
      Array[Any]( 2147483646,  0 ), //max - 1
      Array[Any]( 2147483647,  0 )  //max
    )
  }

  @Test(dataProvider = "tests")
  def verify(intInput: Int, expectedOutput: Int): Unit = {
    val actualOutput = solution(intInput)
    assertEquals(actualOutput, expectedOutput)
  }

}







