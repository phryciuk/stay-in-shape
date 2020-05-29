package org.hryciuk.stayinshape.data_structures.array;

/**
 * 209. Minimum Size Subarray Sum
 * Medium
 * <p>
 * Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.
 * <p>
 * Example:
 * <p>
 * Input: s = 7, nums = [2,3,1,2,4,3]
 * Output: 2
 * Explanation: the subarray [4,3] has the minimal length under the problem constraint.
 * <p>
 * Follow up:
 * If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n).
 */
public class MinimumSizeSubarraySum {

    // Using sliding window technique
    // Time: O(n + n), Space: O(1)
    public int minSubArrayLen(int s, int[] nums) {
        int currentSum = 0;
        int minimalLength = Integer.MAX_VALUE;
        int startOfWindow = 0;
        int endOfWindow = 0;
        for (int i = 0; i < nums.length; ++i) { // O(n)
            currentSum += nums[i];
            if (currentSum >= s) {
                endOfWindow = i;
                while (currentSum >= s) { // this inner loop processes each element only once; O(n)
                    currentSum -= nums[startOfWindow];
                    startOfWindow++;
                }
                minimalLength = Math.min(minimalLength, endOfWindow - startOfWindow + 2);
            }
        }
        return minimalLength == Integer.MAX_VALUE ? 0 : minimalLength;
    }
}
