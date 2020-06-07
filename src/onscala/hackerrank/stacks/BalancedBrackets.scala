package onscala.hackerrank.stacks

import org.scalatest.Assertions
import org.testng.Assert._
import org.testng.annotations.{DataProvider, Test}


/**
  * Site: HackerRank
  * Problem: Balanced Brackets
  *
  * User: Luis Villaca
  * Date: 03/06/2020
  */
class BalancedBrackets extends Assertions {

  val yes = "YES"
  val no = "NO"

  def isBalanced(s: String): String = {

    // 1 - define regular expressions
    val pattern1 = """(.*)(\(\))(.*)""".r // .*().*
    val pattern2 = """(.*)(\[\])(.*)""".r // .*[].*
    val pattern3 = """(.*)(\{\})(.*)""".r // .*{}.*

    // 2 - recursively remove matching pattern from String
      // if balanced, it will be empty in the end of the process
    if (s.isEmpty) yes
    else s match {
      case pattern1 (before,mid,after)  => isBalanced(s"$before$after")
      case pattern2 (before,mid,after)  => isBalanced(s"$before$after")
      case pattern3 (before,mid,after)  => isBalanced(s"$before$after")
      case _ => no
    }
  }

  //Evaluating
  @DataProvider(name= "tests")
  def testData() = {
    Array(
      Array[Any]("[{()}]{}", yes),
      Array[Any]("{[{()}]}", yes),
      Array[Any]("(){}[[]", no),
      Array[Any]("())({}", no)
    )
  }

  @Test(dataProvider = "tests")
  def verify(strInput: String, expectedOutput: String): Unit =
    assertTrue(isBalanced(strInput)  eq expectedOutput)

}
