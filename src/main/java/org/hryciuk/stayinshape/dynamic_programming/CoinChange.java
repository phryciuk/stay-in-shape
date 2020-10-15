package org.hryciuk.stayinshape.dynamic_programming;

/**
 * 322. Coin Change
 * Medium
 * <p>
 * You are given coins of different denominations and a total amount of money amount.
 * Write a function to compute the fewest number of coins that you need to make up that amount.
 * If that amount of money cannot be made up by any combination of the coins, return -1.
 * <p>
 * Example 1:
 * <p>
 * Input: coins = [1, 2, 5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 * <p>
 * Example 2:
 * <p>
 * Input: coins = [2], amount = 3
 * Output: -1
 * <p>
 * Note:
 * You may assume that you have an infinite number of each kind of coin.
 */
public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        int[][] dp = new int[coins.length][amount + 1];

        // first row
        int coin = coins[0];
        for (int i = 1; i < dp[0].length; ++i) {
            if (i < coin) {
                dp[0][i] = -1;
            } else if (coin == i) {
                dp[0][i] = 1;
            } else {
                int remainder = i % coin;
                dp[0][i] = remainder != 0 ? -1 : i / coin;
            }
        }

        // other rows
        for (int i = 1; i < dp.length; ++i) {
            coin = coins[i];
            for (int j = 1; j < dp[i].length; ++j) {
                if (j < coin) {
                    dp[i][j] = dp[i - 1][j] != -1 ? dp[i - 1][j] : -1;
                } else if (coin == j) {
                    dp[i][j] = 1;
                } else {
                    if (dp[i][j - coin] != -1 && dp[i - 1][j] != -1) {
                        dp[i][j] = Math.min(dp[i][j - coin] + 1, dp[i - 1][j]);
                    } else if (dp[i][j - coin] != -1) {
                        dp[i][j] = dp[i][j - coin] + 1;
                    } else if (dp[i - 1][j] != -1) {
                        dp[i][j] = dp[i - 1][j];
                    } else {
                        dp[i][j] = -1;
                    }
                }
            }
        }
        return dp[coins.length - 1][amount];
    }

}
