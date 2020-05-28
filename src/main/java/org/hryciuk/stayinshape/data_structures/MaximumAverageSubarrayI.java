package org.hryciuk.stayinshape.data_structures;

/**
 * 643. Maximum Average Subarray I
 * Easy
 *
 * Given an array consisting of n integers, find the contiguous subarray of given length k that has the maximum average value. And you need to output the maximum average value.
 *
 * Example 1:
 *
 * Input: [1,12,-5,-6,50,3], k = 4
 * Output: 12.75
 * Explanation: Maximum average is (12-5-6+50)/4 = 51/4 = 12.75
 *
 *
 *
 * Note:
 *
 *     1 <= k <= n <= 30,000.
 *     Elements of the given array will be in the range [-10,000, 10,000].
 */
public class MaximumAverageSubarrayI {

    // Using sliding window technique
    public double findMaxAverage(int[] nums, int k) {
        double windowSum = 0;
        double maxAverage = Double.NEGATIVE_INFINITY;
        int windowStart = 0;
        for (int i = 0; i < nums.length; ++i) {
            windowSum += nums[i];
            if (i >= k - 1) {
                maxAverage = Math.max(maxAverage, windowSum / k);
                windowSum -= nums[windowStart];
                windowStart++;
            }
        }
        return maxAverage;
    }
}
