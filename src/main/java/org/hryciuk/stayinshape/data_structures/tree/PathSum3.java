package org.hryciuk.stayinshape.data_structures.tree;

/**
 * https://leetcode.com/problems/path-sum-iii/
 * 437. Path Sum III
 * Easy
 *
 * You are given a binary tree in which each node contains an integer value.
 *
 * Find the number of paths that sum to a given value.
 *
 * The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).
 *
 * The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.
 *
 * Example:
 *
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 *
 *       10
 *      /  \
 *     5   -3
 *    / \    \
 *   3   2   11
 *  / \   \
 * 3  -2   1
 *
 * Return 3. The paths that sum to 8 are:
 *
 * 1.  5 -> 3
 * 2.  5 -> 2 -> 1
 * 3. -3 -> 11
 */
public class PathSum3 {
    // O(n^2)
    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        int[] numberOfPaths = new int[1];
        dfs(root, sum, numberOfPaths);
        return numberOfPaths[0];
    }

    private void dfs(TreeNode root, int sum, int[] numberOfPaths) {
        if (root == null) {
            return;
        }
        dfs(root.left, sum, numberOfPaths);
        dfsWithCounting(root, 0, sum, numberOfPaths);
        dfs(root.right, sum, numberOfPaths);
    }

    private void dfsWithCounting(TreeNode root, int sum, int wantedSum, int[] numberOfPaths) {
        if (root == null) {
            return;
        }
        if (sum + root.val == wantedSum) {
            numberOfPaths[0]++;
        }
        dfsWithCounting(root.left, sum + root.val, wantedSum, numberOfPaths);
        dfsWithCounting(root.right, sum + root.val, wantedSum, numberOfPaths);
    }
}
