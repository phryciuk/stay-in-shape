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

    public int lengthOfMaxSubarray(int[] nums) {
        int currentMax = 0;
        int bestMax = Integer.MIN_VALUE;
        int start = 0;
        int end = 0;
        int s = 0;
        for (int i = 0; i < nums.length; ++i) {
            currentMax = currentMax + nums[i];
            if (currentMax > bestMax) {
                end = i;
                start = s;
                bestMax = currentMax;
            }
            if (currentMax < 0) {
                currentMax = 0;
                s = i + 1;
            }
        }
        return end - start + 1;
    }
}
