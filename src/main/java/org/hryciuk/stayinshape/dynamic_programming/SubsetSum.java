package org.hryciuk.stayinshape.dynamic_programming;

/**
 *
 * Given a set of positive numbers, determine if there exists a subset whose sum is equal to a given number ‘S’.
 * Input: {1, 2, 3, 7}, S=6
 * Output: True
 * The given set has a subset whose sum is '6': {1, 2, 3}
 */
public class SubsetSum {
    public boolean subsetSum(int[] nums, int s) {
        boolean[][] dp = new boolean[nums.length][s + 1];
        // first column
        for (int i = 0; i < nums.length; ++i) {
            dp[i][0] = (nums[i] == s);
        }
        // first row
        for (int i = 0; i < s + 1; i++) {
            if (i < nums[0]) {
                dp[0][i] = false;
            } else {
                dp[0][i] = nums[0] == i;
            }
        }
        // all else
        for (int i = 1; i < nums.length; ++i) {
            for (int j = 1; j < s + 1; ++j) {
                if (j < nums[i]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                }
            }
        }
        return dp[nums.length - 1][s];
    }

    public boolean subsetEqualToSum(int[] nums, int s) {
        boolean[][] dp = new boolean[nums.length][s + 1];
        // first row
        for (int i = 0; i < s + 1; ++i) {
            dp[0][i] = nums[0] == i;
        }
        // first column
        for (int i = 0; i < nums.length; ++i) {
            dp[i][0] = nums[i] == 0;
        }
        // all else
        for (int i = 1; i < nums.length; ++i) {
            for (int j = 1; j < s + 1; ++j) {
                if (j < nums[i]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                }
            }
        }
        return dp[nums.length - 1][s];
    }

    public boolean subsetSumRecursive(int[] nums, int s) {
        Boolean[][] dp = new Boolean[nums.length][s + 1];
        return canPartition(nums, 0, s, dp);
    }

    public boolean canPartition(int[] nums, int current, int s, Boolean[][] dp) {
        if (current >= nums.length || s < 0) {
            return false;
        }
        if (dp[current][s] != null) {
            return dp[current][s];
        }
        if (s == 0) {
            return true;
        }
        // if we include that number
        boolean included = canPartition(nums, current + 1, s - nums[current], dp);
        boolean exclued = canPartition(nums, current + 1, s, dp);
        dp[current][s] = included || exclued;
        return  included || exclued;
    }

    public boolean subsetSumRec(int[] nums, int s) {
        boolean[][] dp = new boolean[nums.length][s + 1];
        // first column is always true, since we can do it with empty set
        for (int i = 0; i < nums.length; ++i) {
            dp[i][0] = true;
        }
        // first row
        for (int i = 1; i < s + 1; ++ i) {
            if (i == nums[0]) {
                dp[0][i] = true;
            }
        }
        // following rows
        for (int i = 1; i < nums.length; ++i) {
            for (int j = 1; j < s + 1; ++j) {
                if (j < nums[i]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                }
            }
        }
        return dp[nums.length - 1][s];
    }

    public boolean subsetSumExist(int[] nums, int s) {
        // first we create an array where we will store our subresults
        boolean[][] dp = new boolean[nums.length][s + 1];

        // first column; with every subset we can have empty set
        for (int i = 0; i < nums.length; ++i) {
            dp[i][0] = true;
        }

        // first row, is true only when number is equal to S
        for (int i = 1; i < s + 1; ++i) {
            dp[0][i] = (nums[0] == i);
        }

        // other rows
        for (int i = 1; i < nums.length; ++i) {
            for (int j = 1; j < s + 1; ++j) {
                if (j < nums[i]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                }
            }
        }
        return dp[nums.length - 1][s];
    }
}
