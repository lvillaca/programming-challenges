package onscala.codility.primencomposite

import org.scalatest.Assertions
import org.testng.Assert._
import org.testng.annotations.{DataProvider, Test}

import scala.annotation.tailrec

/**
  * Site: Codility
  * Problem: Peaks 
  *
  * User: Luis Villaca
  * Date: 24/05/2020
  */
class Peaks extends Assertions {

  def solution(a: Array[Int]): Int  = {

    val arrLength = a.length
    if (arrLength < 3) 0
    else {
      // 1 - aux accumulated array -----------------------------------------
      val accArray = new Array[Int](arrLength)

      // initial index
      accArray(0) = 0

      (1 to arrLength-2).foreach(internalIndex => {
        if (a(internalIndex-1) < a(internalIndex) && a(internalIndex) > a(internalIndex+1)){
          // a peek
          accArray(internalIndex) = accArray(internalIndex-1) +1;
        } else {
          accArray(internalIndex) = accArray(internalIndex-1);
        }
      })

      // last index
      accArray(arrLength-1) = accArray(arrLength-2)
      val nbrPeaks = accArray(arrLength-1)

      // 2 - helper functions  -----------------------------------------


      val hasPeakInBlock = (init: Int, end: Int) => {
        if (init == 0) accArray(end) > 0
        else accArray(end) > accArray(init - 1)
      }

      val hasPeakInBlocks = (factor: Int) => {
        val blockSize = arrLength / factor;
        def hasPeakInBlocksRec(initBlock: Int, endBlock: Int, maxAcc:Int): Int = {
          if (endBlock > arrLength) maxAcc
          else if (!hasPeakInBlock(initBlock, endBlock)) 0
          else hasPeakInBlocksRec(initBlock+blockSize, endBlock+blockSize, maxAcc+1)
        }
        val initBlock = 0
        val endBlock =  blockSize - 1
        hasPeakInBlocksRec(initBlock, endBlock, 0) == factor
      }

      val isFactor = (x:Int) => arrLength % x ==0

      // 3 - get max factor that has all peaks ---------------------------

      (1 to nbrPeaks).filter(isFactor) //is factor
        .filter(hasPeakInBlocks) // map to block size
        .reduceOption(_ max _).getOrElse(0)
    }

  }


  //Evaluating
  @DataProvider(name= "tests")
  def testData() = Array(
    Array[Any](Array(1, 2, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2), 3),
    Array[Any](Array(1, 3, 2, 1), 1),
    Array[Any](Array(1, 4, 1, 3, 2), 1),
    Array[Any](Array(1, 2, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2, 1, 2, 5, 2), 4),
    Array[Any](Array(0, 1, 0, 1, 0, 1, 0, 1), 2),
    Array[Any](Array(0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1), 4),
    Array[Any](Array(0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1), 4),
    Array[Any](Array(0, 1, 0, 0, 0, 1, 0, 0, 1, 0, 1, 0), 4),
    Array[Any](Array(0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0), 4),
    Array[Any](Array(0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 1, 0, 1, 0, 0, 0), 4),
    Array[Any](Array(0, 1, 0, 0, 1, 0, 0, 1, 0), 3),
    Array[Any](Array(0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0), 1),
    Array[Any](Array(1, 2, 3, 4, 5, 6, 5, 5, 5, 6, 5, 6), 2),
    Array[Any](Array(1, 2, 1, 1, 2, 1, 1, 2, 1, 1, 2, 1, 1, 2, 1, 1, 2, 1, 1, 2, 1, 1, 2, 1, 1, 2, 1, 1, 2, 1), 10),
    Array[Any](Array(5), 0),
  )

  @Test(dataProvider = "tests")
  def verify(arrayInput: Array[Int], expectedOutput: Int): Unit = {
    val actualOutput = solution(arrayInput)
    assertEquals(actualOutput, expectedOutput)
  }

}







