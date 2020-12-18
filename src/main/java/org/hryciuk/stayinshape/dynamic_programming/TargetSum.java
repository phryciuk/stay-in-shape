package org.hryciuk.stayinshape.dynamic_programming;

public class TargetSum {
    public int findTargetSumWays(int[] nums, int S) {
        return helper(nums, 0,  S);
    }

    private int helper(int[] nums, int currentIndex, int remainingAmount) {
        if (currentIndex < 0 || currentIndex >= nums.length) {
            return 0;
        }
        if (currentIndex == nums.length - 1 && (remainingAmount - nums[currentIndex] == 0 || remainingAmount + nums[currentIndex] == 0)) {
            return 1;
        }
        int withPlus = helper(nums, currentIndex + 1, remainingAmount - nums[currentIndex]);
        int withMinus = helper(nums, currentIndex + 1, remainingAmount + nums[currentIndex]);
        return withMinus + withPlus;
    }
}
