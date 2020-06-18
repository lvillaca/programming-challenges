# MaxSliceSum

The [Scala](../../../src/onscala/codility/maxslice/MaxSliceSum.scala) and [Java](../../../src/onjava/codility/maxslice/MaxSliceSum.java) source codes present the solution for [this](https://app.codility.com/programmers/lessons/9-maximum_slice_problem/max_slice_sum/) challenge.

The challenge description was not reproduced due to copyrights.

Strategy:
 - loop through array
   - accumulate as long as the new addition (previous sum + new value) contributes to maxSliceSum (result > 0)
   - if new addition > new value - keep previous value, remain accumulating
   - if new value > = new addition - new value is assigned to accumulation
   - accumulation became <= 0, it is set to 0