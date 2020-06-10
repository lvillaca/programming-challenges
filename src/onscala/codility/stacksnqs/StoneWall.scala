package onscala.codility.stacksnqs

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
class StoneWall extends Assertions {

  def solution(h: Array[Int]): Int  = {
              if (h.isEmpty) 0
              else {
                var innerCache = List[Int]()
                var innerCount = 0

                for (h_item <- h) {
                  // 1 - descending - while new high < current cached entry,
                  //     iteratively ignore this entry and compare with previous one
                  while (!innerCache.isEmpty && innerCache.head > h_item) innerCache = innerCache.tail

                  // 2 - at the end of 1, cache may be empty, or current entry >= new high
                  //     add count and include new high in cache
                  if (innerCache.isEmpty || h_item > innerCache.head) {
                    innerCache = h_item :: innerCache
                    innerCount += 1
                  }

                  // 3 - plateau - while new high = current cached entry - do nothing
                }

                innerCount
              }

    }

  //Evaluating
  @DataProvider(name= "tests")
  def testData() = Array(
    Array[Any](Array(8, 8, 5, 7, 9, 8, 7, 4, 8), 7),
    Array[Any](Array(0), 1),
    Array[Any](Array(1, 1, 1), 1)
  )


  @Test(dataProvider = "tests")
  def verify(arrayInput: Array[Int], expectedOutput: Int): Unit = {
    val actualOutput = solution(arrayInput)
    assertEquals(actualOutput, expectedOutput)
  }

}