package onscala.hackerrank.implementations

import org.scalatest.Assertions
import org.testng.Assert._
import org.testng.annotations.{DataProvider, Test}

/**
  * Site: HackerRank
  * Problem: Picking Numbers
  *
  * User: Luis Villaca
  * Date: 24/05/2020
  */
class PickingNumbers extends Assertions {

  def pickingNumbers(a: Array[Int]): Int = {

    def sum(initialNum: Int, innArray: Array[Int]): Int = {
      if (innArray.isEmpty) 0
      else {
        // two possibilities
        val sumUp = innArray.filter({
          case n: Int if n - initialNum ==0 || n - initialNum == 1 => true
          case _ => false
        }).map( _ => 1).sum
        val sumDown = innArray.filter({
          case n: Int if n - initialNum ==0 || n - initialNum == -1 => true
          case _ => false
        }).map( _ => 1).sum

        math.max(sumUp,sumDown)
      }
    }

    def runningSum(prevSum: Int, aSet: Set[Int], innArray: Array[Int]): Int = {
      if (aSet.isEmpty) prevSum
      else {
        val thissum = math.max(prevSum, sum(aSet.head, innArray))
        runningSum(thissum,aSet.tail, innArray)
      }
    }

    runningSum(0,a.toSet,a)
  }

  //Evaluating
  @DataProvider(name= "tests")
  def testData() = {
    Array(
      Array[Any](Array(1, 2, 2, 3, 1, 2), 5),
      Array[Any](Array(4, 6, 5, 3, 3, 1), 3)
    )
  }

  @Test(dataProvider = "tests")
  def verify(arrayIntInput: Array[Int], expectedOutput: Int): Unit =
    assertEquals(pickingNumbers(arrayIntInput),expectedOutput)


}

