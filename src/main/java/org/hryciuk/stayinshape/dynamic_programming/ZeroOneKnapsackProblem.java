package org.hryciuk.stayinshape.dynamic_programming;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem Statement #
 * Given two integer arrays to represent weights and profits of ‘N’ items,
 * we need to find a subset of these items which will give us maximum profit such that their cumulative weight
 * is not more than a given number ‘C’.
 * Each item can only be selected once, which means either we put an item in the knapsack or we skip it.
 */
public class ZeroOneKnapsackProblem {

    /**
     * Essentially, we want to find the maximum profit for every sub-array and for every possible capacity.
     * dp[i][c] will represent the maximum knapsack profit for capacity ‘c’ calculated from the first ‘i’ items.
     * The above solution has time and space complexity of O(N*C) where ‘N’ represents total items and ‘C’ is the maximum capacity.
     */
    public int findMaximumProfitBottomUp(int[] weight, int[] profit, int capacity) {
        int[][] dp = new int[profit.length][capacity + 1];
        return knapsackIterative(dp, weight, profit, capacity);
    }

    public int findMaximumProfitBottomUpSpaceOptimized(int[] weight, int[] profit, int capacity) {
        int[][] dp = new int[2][capacity + 1];
        return knapsackIterativeSpaceOptimized(dp, weight, profit, capacity);
    }

    // Time: O(n * c)
    // Space: O(c * 2)
    private int knapsackIterativeSpaceOptimized(int[][] dp, int[] weight, int[] profit, int capacity) {

        // we initialize the first row
        for (int i = 1; i < dp[0].length; ++i) {
            dp[0][i] = weight[0] <= i ? profit[0] : 0;
        }
        // we initialize other rows
        for (int i = 1; i < weight.length; ++i) {
            for (int j = 1; j < dp[i % 2].length; ++j) {
                if (j < weight[i]) {
                    dp[i % 2][j] = dp[(i - 1) % 2][j];
                } else {
                    dp[i % 2][j] = Math.max(dp[(i - 1) % 2][j], profit[i] + dp[(i - 1) % 2][j - weight[i]]);
                }
            }
        }
        return dp[(weight.length - 1) % 2][capacity];
    }

    private int knapsackIterative(int[][] dp, int[] weight, int[] profit, int capacity) {
        // we initialize the first column; could be omitted
        for (int i = 0; i < dp.length; ++i) {
            dp[i][0] = 0;
        }

        // we initialize the first row
        for (int i = 1; i < dp[0].length; ++i) {
            dp[0][i] = weight[0] <= i ? profit[0] : 0;
        }

        // we initialize other rows
        for (int i = 1; i < dp.length; ++i) {
            for (int j = 1; j < dp[i].length; ++j) {
                if (j < weight[i]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], profit[i] + dp[i - 1][j - weight[i]]);
                }
            }
        }
        return dp[profit.length - 1][capacity];
    }

    /**
     * Since our memoization array dp[profits.length][capacity+1] stores the results for all the subproblems,
     * we can conclude that we will not have more than N*C subproblems
     * (where ‘N’ is the number of items and ‘C’ is the knapsack capacity).
     * This means that our time complexity will be O(N*C).
     * Space: O(N*C) memoization array + O(n) call stack ==> asymptotically O(N*C)
     */
    public int findMaximumProfitTopDownWithMemoization(int[] weight, int[] profit, int capacity) {
        Integer[][] dp = new Integer[profit.length][capacity + 1]; // capacity + 1 because otherwise we could get ArrayIndexOutOfBoundsException initially
        return knapsackRecursiveTopDownWithMemoization(dp, weight, profit, capacity, 0);
    }

    private int knapsackRecursiveTopDownWithMemoization(Integer[][] dp, int[] weight, int[] profit, int currentCapacity, int currentIndex) {
        if (currentCapacity <= 0 || currentIndex >= profit.length) {
            return 0;
        }

        // if we have already solved a similar problem, return the result from memory
        if (dp[currentIndex][currentCapacity] != null) {
            return dp[currentIndex][currentCapacity];
        }

        // now we have to options:
        // - include the element
        // - do not include the element
        int profitWithItemIncluded = 0;
        if (currentCapacity - weight[currentIndex] >= 0) {
            profitWithItemIncluded = profit[currentIndex] + knapsackRecursiveTopDownWithMemoization(dp, weight, profit, currentCapacity - weight[currentIndex], currentIndex + 1);
        }
        int profitWithItemExcluded = knapsackRecursiveTopDownWithMemoization(dp, weight, profit, currentCapacity, currentIndex + 1);

        dp[currentIndex][currentCapacity] = Math.max(profitWithItemExcluded, profitWithItemIncluded);
        return dp[currentIndex][currentCapacity];
    }

    /**
     * for each item 'i'
     * create a new set which INCLUDES item 'i' if the total weight does not exceed the capacity, and
     * recursively process the remaining capacity and items
     * create a new set WITHOUT item 'i', and recursively process the remaining items
     * return the set from the above two sets with higher profit
     */
    // Time: O(2^n), where n = number of items
    // Space complexity: O(n)
    public int findMaximumProfitBruteForce(int[] weight, int[] profit, int capacity) {
        return this.knapsackRecursive(weight, profit, capacity, 0);
    }

    private int knapsackRecursive(int[] weight, int[] profit, int currentCapacity, int currentIndex) {
        if (currentCapacity <= 0 || currentIndex >= profit.length) {
            return 0;
        }
        // now we have 2 options:
        // - include the element
        // - do not include the element
        int profitWithItemIncluded = 0;
        if (currentCapacity - weight[currentIndex] >= 0) {
            profitWithItemIncluded = profit[currentIndex] + knapsackRecursive(weight, profit, currentCapacity - weight[currentIndex], currentIndex + 1);
        }
        int profitWithItemExcluded = knapsackRecursive(weight, profit, currentCapacity, currentIndex + 1);
        return Math.max(profitWithItemExcluded, profitWithItemIncluded);
    }

    public int maxProfit(int[] weights, int[] profits, int capacity) {
        Integer[][] dp = new Integer[weights.length][capacity + 1];
        return helper(weights, profits, capacity, 0, dp);
    }

    public int helper(int[] weights, int[] profits, int capacity, int current, Integer[][] dp) {
        if (current >= weights.length || capacity <= 0) {
            return 0;
        }
        if (dp[current][capacity] != null) {
            return dp[current][capacity];
        }
        // either we include the element or exclude that
        int included = 0;
        if (capacity - weights[current] >= 0) {
            included = profits[current] + helper(weights, profits, capacity - weights[current], current + 1, dp);
        }
        int excluded = helper(weights, profits, capacity, current + 1, dp);
        dp[current][capacity] = Math.max(included, excluded);
        return dp[current][capacity];
    }
}
