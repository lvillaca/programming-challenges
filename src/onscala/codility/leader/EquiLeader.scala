package onscala.codility.leader

import org.scalatest.Assertions
import org.testng.Assert._
import org.testng.annotations.{DataProvider, Test}

import scala.collection.mutable.Map
import scala.util.Try

/**
  * Site: HackerRank
  * Problem: EquiLeader
  *
  * User: Luis Villaca
  * Date: 03/05/2020
  */
class EquiLeader extends Assertions {

  private val LEFT_TO_RIGHT = 0
  private val RIGHT_TO_LEFT = 1

  def getLeader(a: Array[Int]): Option[Int] = {
    var leader: Option[Int] = None

    // accumulated values
    val candidateAccum = Map[Int, Int]()

    // define target for count (50% round down to nearest int)
    val target50percent = a.length / 2

    Try( // handles abort
      a.foreach(candidate=> {
        //update candidate counter
        val candidateCount = candidateAccum.getOrElse(candidate,0) + 1
        candidateAccum(candidate) = candidateCount

        if (candidateCount > target50percent) { // found the leader!
          leader = Some(candidate)
          throw new RuntimeException("Stopping Stream Processing")
        }
    }))

    return leader
  }

  def getLeaderMarks(direction: Int, leader: Int, a: Array[Int]): Array[Boolean] = {
    // response data structure
    val leaders =  Array.fill[Boolean](a.length)(false)

    // accumulated values
    var accumLeaderCounter = 0

    a.indices
      .map(index => {
        // map each index to Tuple containing
        //    - accumulated leader counter (up to this index),
        //    - number of elements elements in this sequence
        //    - innerIndex - the position of the response data structure

        var innerIndex = index
        // define how to traverse based on direction
        if (direction == RIGHT_TO_LEFT) innerIndex = a.length - 1 - index
        val element = a(innerIndex)
        // check if it's a leader if so, update counter
        if (element == leader) { // update count for leader
          accumLeaderCounter += 1
        }
        // # elements in this sequence
        val nbrElementsInSequence = index + 1

        //return a Tuple
        (accumLeaderCounter,nbrElementsInSequence, innerIndex)
    })
      .filter({
        // proceed if there is an internal leader
        case (leaderCounter, nbrElements, _) =>
        leaderCounter > (nbrElements / 2)}
    )
      .foreach({
        // mark related position if it's a internal leader (filtered above)
        case (_, _, index) =>
          leaders(index) = true})

    leaders
  }

  def solution(a: Array[Int]): Int  = {

    var totalEquileaders = 0

    // first check if there is a leader (otherwise there are no equileaders)
    val leader = getLeader(a)

    if (leader.isDefined) {
      val leadersLeftToRight = getLeaderMarks(LEFT_TO_RIGHT, leader.get, a)
      val leadersRightToLeft = getLeaderMarks(RIGHT_TO_LEFT, leader.get, a)

      (0 to leadersLeftToRight.length-2).foreach( index => {
        if (leadersLeftToRight(index) && leadersRightToLeft(index + 1)) {
          totalEquileaders += 1
        }
      })}

    totalEquileaders

    }

  //Evaluating
  @DataProvider(name= "tests")
  def testData() = Array(
    Array[Any](Array(4, 3, 4, 4, 4, 2), 2),
    Array[Any](Array(4, 4, 2, 5, 3, 4, 4, 4), 3),
    Array[Any](Array(1, 2, 1, 1, 2, 1), 3),
    Array[Any](Array(4, 4), 1)
  )


  @Test(dataProvider = "tests")
  def verify(arrayInput: Array[Int], expectedOutput: Int): Unit = {
    val actualOutput = solution(arrayInput)
    assertEquals(actualOutput, expectedOutput)
  }

}