package org.hryciuk.stayinshape.data_structures.array;

/**
 *

 Given a binary array, find the maximum number of consecutive 1s in this array.

 Example 1:

 Input: [1,1,0,1,1,1]
 Output: 3
 Explanation: The first two digits or the last three digits are consecutive 1s.
 The maximum number of consecutive 1s is 3.

 Note:

 The input array will only contain 0 and 1.
 The length of input array is a positive integer and will not exceed 10,000

 */
class MaxConsecutiveOnes {
  public int findMaxConsecutiveOnes(int[] nums) {
    // 2 zmienne. Jedna to lokalny max, druga to globalny
    int max = 0;
    int currentMax = 0;
    for (int i = 0; i < nums.length; ++i) {
      if (nums[i] == 1) {
        // jak 1 to zwiększamy lokalny max
        currentMax++;
      } else {
        // koniec serii 1. sprawdzamy czy lokalny max jest wiekszy niz globalny i zerujemy lokalny max
        max = currentMax > max ? currentMax : max;
        currentMax = 0;
      }
    }
    // ostatnie sprawdzenie na wypadek gdyby najdluzszy ciag jedynek byl na samym koncu, bez 0 na koncu
    max = currentMax > max ? currentMax : max;
    return max;
  }
}
