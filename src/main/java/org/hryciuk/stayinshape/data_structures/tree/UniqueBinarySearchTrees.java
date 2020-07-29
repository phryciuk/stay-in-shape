package org.hryciuk.stayinshape.data_structures.tree;

/**
 * 96. Unique Binary Search Trees
 * Medium
 * https://leetcode.com/problems/unique-binary-search-trees/
 * Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?
 *
 * Example:
 *
 * Input: 3
 * Output: 5
 * Explanation:
 * Given n = 3, there are a total of 5 unique BST's:
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 *
 *
 *
 * Constraints:
 *
 *     1 <= n <= 19
 */
public class UniqueBinarySearchTrees {
    // np. drzewko 3, [1,2,3]
    // rootem moze byc 1 wtedy lewe poddrzewo = dp[0] a prawe poddrzewo dp[2]
    // rootem moze byc 2 wtedy lewe poddrzewo = dp[1] a prawe poddrzewo dp[1]
    // rootem moze byc 3 wtedy lewe poddrzewo = dp[2] a prawe poddrzewo dp[0]
    // suma iloczynow jest odpowiedzia
    public int numTrees(int n) {
        int[] dp;
        if (n < 2) {
            dp = new int[3];
        } else {
            dp = new int[n + 1];
        }
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        if (n == 1 || n == 2) {
            return dp[n];
        }
        for (int i = 3; i <= n; ++i) {
            int partialSum = 0;
            for (int j = 0; j < i; j++) {
                partialSum += dp[j] * dp[i - j - 1];
            }
            dp[i] = partialSum;
        }
        return dp[n];
    }
}
