package org.hryciuk.stayinshape.dynamic_programming;

import java.util.Arrays;

/**
 * 416. Partition Equal Subset Sum
 * Medium
 * <p>
 * Given a non-empty array nums containing only positive integers, find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,5,11,5]
 * Output: true
 * Explanation: The array can be partitioned as [1, 5, 5] and [11].
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [1,2,3,5]
 * Output: false
 */
public class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length == 0) {
            return true;
        }
        int sum = 0;
        for (int i = 0; i < nums.length; ++i) {
            sum += nums[i];
        }
        if (sum % 2 != 0) {
            return false;
        }
        int half = sum / 2;
        Boolean[][] memoization = new Boolean[nums.length][half + 1];
        return helper(nums, 0, half, memoization);
    }

    private boolean helper(int[] nums, int currentIndex, int remaining, Boolean[][] memoization) {
        if (currentIndex < 0 || currentIndex >= nums.length) {
            return false;
        }
        if (remaining == 0) {
            return true;
        }
        if (memoization[currentIndex][remaining] != null) {
            return memoization[currentIndex][remaining];
        }
        boolean inlcudingThisNumber = false;
        if (remaining - nums[currentIndex] >= 0) {
            inlcudingThisNumber = helper(nums, currentIndex + 1, remaining - nums[currentIndex], memoization);
        }
        boolean excludingThisNumber = helper(nums, currentIndex + 1, remaining, memoization);
        boolean result = inlcudingThisNumber || excludingThisNumber;
        memoization[currentIndex][remaining] = result;
        return memoization[currentIndex][remaining];
    }

    public boolean canPartitionBottomUp(int[] nums) {
        if (nums == null || nums.length == 0) {
            return true;
        }
        int sum = 0;
        for (int i = 0; i < nums.length; ++i) {
            sum += nums[i];
        }
        if (sum % 2 != 0) {
            return false;
        }
        int half = sum / 2;
        boolean[][] dp = new boolean[nums.length][half + 1];

        // first column
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == half) {
                dp[i][0] = true;
            }
        }

        // first row
        // with only one number, we can form a subset only when the required sum is equal to its value
        for (int i = 0; i < half + 1; ++i) {
            dp[0][i] = (nums[0] == i);
        }

        // rest of the rows
        for (int i = 1; i < nums.length; ++i) {
            for (int j = 1; j < half + 1; ++j) {
                // if we can get the sum 'j' without the number at index 'i'
                if (dp[i - 1][j]) {
                    dp[i][j] = dp[i - 1][j];
                } else if (j >= nums[i]) { // else if we can find a subset to get the remaining sum
                    dp[i][j] = dp[i - 1][j - nums[i]];
                }
            }
        }
        return dp[nums.length - 1][half];
    }

    public boolean partitionEqualSubsetSum2(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; ++i) {
            sum += nums[i];
        }
        if (sum % 2 == 1) {
            return false;
        }
        int half = sum / 2;
        Boolean[][] memo = new Boolean[nums.length][half + 1];
        return helper2(nums, 0, half, memo);
    }

    private boolean helper2(int[] nums, int currentIndex, int remainingVal, Boolean[][] memo) {
        if (currentIndex < 0 || currentIndex >= nums.length) {
            return false;
        }
        if (remainingVal == 0) {
            return true;
        }
        if (memo[currentIndex][remainingVal] != null) {
            return memo[currentIndex][remainingVal];
        }
        boolean includingThisElement = false;
        if (remainingVal - nums[currentIndex] >= 0) {
            includingThisElement = helper2(nums, currentIndex + 1, remainingVal - nums[currentIndex], memo);
        }
        boolean excludingThisElement = helper2(nums, currentIndex + 1, remainingVal, memo);
        memo[currentIndex][remainingVal] = excludingThisElement || includingThisElement;
        return memo[currentIndex][remainingVal];
    }

    public boolean partitionEqualSubsetSum3(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; ++i) {
            sum += nums[i];
        }
        if (sum % 2 == 1) {
            return false;
        }
        int half = sum / 2;
        boolean[][] dp = new boolean[nums.length][half + 1];
        // first column
        for (int i = 0; i < nums.length; ++i) {
            dp[i][0] = (nums[i] == half);
        }
        // first row
        for (int i = 0; i < half + 1; ++i) {
            if (i < nums[0]) {
                dp[0][i] = false;
            } else {
                if (i == nums[0]) {
                    dp[0][i] = true;
                }
            }
        }
        // all else
        for (int i = 1; i < nums.length; ++i) {
            for (int j = 1; j < half + 1; ++j) {
                if (j < nums[i]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    if (dp[i - 1][j]) {
                        dp[i][j] = true;
                    } else {
                        if (j >= nums[i]) {
                            dp[i][j] = dp[i - 1][j - nums[i]];
                        }
                    }
                }
            }
        }
        return dp[nums.length - 1][half];
    }

}
