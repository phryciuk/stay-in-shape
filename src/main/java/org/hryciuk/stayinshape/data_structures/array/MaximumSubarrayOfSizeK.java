package org.hryciuk.stayinshape.data_structures.array;

/**
 * Problem Statement #
 *
 * Given an array of positive numbers and a positive number ‘k’, find the maximum sum of any contiguous subarray of size ‘k’.
 *
 * Example 1:
 *
 * Input: [2, 1, 5, 1, 3, 2], k=3
 * Output: 9
 * Explanation: Subarray with maximum sum is [5, 1, 3].
 *
 * Example 2:
 *
 * Input: [2, 3, 4, 1, 5], k=2
 * Output: 7
 * Explanation: Subarray with maximum sum is [3, 4].
 */
public class MaximumSubarrayOfSizeK {

    public int findMaxSumSubarray(int[] arr, int k) {
        int maximumSum = 0;
        int currentSum = 0;
        for (int i = 0; i < arr.length; ++i) {
            currentSum += arr[i];
            if (i >= k - 1) {
                maximumSum = Math.max(currentSum, maximumSum);
                currentSum -= arr[i - k + 1];
            }
        }
        return maximumSum;
    }

    public int maxSumOfContiguousSubarray(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = 0;
        int start = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; ++i) {
            int current = nums[i];
            sum += current;
            if (i - start + 1 == k) {
                max = Math.max(max, sum);
                sum -= nums[start];
                start++;
            }
        }
        return max;
    }

}
