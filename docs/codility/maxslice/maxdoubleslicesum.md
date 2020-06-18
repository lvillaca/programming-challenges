# MaxDoubleSliceSum

The [Scala](../../../src/onscala/codility/maxslice/MaxDoubleSliceSum.scala) and [Java](../../../src/onjava/codility/maxslice/MaxDoubleSliceSum.java) source codes present the solution for [this](https://app.codility.com/programmers/lessons/9-maximum_slice_problem/max_double_slice_sum/) challenge.

The challenge description was not reproduced due to copyrights.

Strategy:
 - use Kadane's algorithm to capture max partial sums from 2 subarrays:
   - one (X) accumulating the max subarray of elements ending at an index (left to right accumulation)
   - another one (Y) accumulating the max subarray of elements starting with an index (right to left accumulation)
 - then, since we are looking into non-contiguous slices, get the max sum for any index, where:
   - max sum = X(index-1) + Y(index+1)