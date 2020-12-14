package org.hryciuk.stayinshape.dynamic_programming;

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
}
