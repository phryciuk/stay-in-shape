package org.hryciuk.stayinshape.dynamic_programming;

import java.util.Arrays;

/**
 * 416. Partition Equal Subset Sum
 * Medium
 *
 * Given a non-empty array nums containing only positive integers, find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,5,11,5]
 * Output: true
 * Explanation: The array can be partitioned as [1, 5, 5] and [11].
 *
 * Example 2:
 *
 * Input: nums = [1,2,3,5]
 * Output: false
 */
public class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
//        boolean[][] dp = new boolean[nums.length][sum + 1];
        int sum = countSum(nums);
        // if 'sum' is a an odd number, we can't have two subsets with equal sum
        if(sum % 2 != 0)
            return false;
        return canPartitionRecursively(nums, sum / 2, 0);
    }

    private int countSum(int[] nums) {
        return Arrays.stream(nums).sum();
    }

    private boolean canPartitionRecursively(int[] nums, int sum, int currentIndex) {
        if (sum == 0) {
            return true;
        }
        if (sum > 0 || currentIndex >= nums.length) {
            return false;
        }
        boolean takingThatItem = false;
        boolean notTakingThatItem = false;
        if (nums[currentIndex] > sum) {
            notTakingThatItem = canPartitionRecursively(nums, sum, currentIndex + 1);
        } else {
            takingThatItem = canPartitionRecursively(nums, sum - nums[currentIndex], currentIndex + 1);
        }
        return takingThatItem || notTakingThatItem;
    }
}
