package org.hryciuk.stayinshape.data_structures.array;

public class MaximumSubarray {

    // Using Kadane's algorithm.
    // main idea is maxSubArray is Max(thisElement, thisElement + maxUpToThisPoint)
    public int maxSubArrayKadane(int[] nums) {
        int max = nums[0];
        int currentSum = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            max = Math.max(currentSum, max);
        }
        return max;
    }

    public int maxSubArray(int[] nums) {
        int runningSum = 0;
        int maxSubArraySum = Integer.MIN_VALUE;
        int maxNegativeNumber = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] <= 0 && runningSum + nums[i] <= 0) {
                runningSum = 0;
                maxNegativeNumber = Math.max(nums[i], maxNegativeNumber);
            } else {
                runningSum += nums[i];
                maxSubArraySum = Math.max(maxSubArraySum, runningSum);
            }
        }
        return Math.max(maxNegativeNumber, maxSubArraySum);
    }
}
