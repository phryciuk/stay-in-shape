package org.hryciuk.stayinshape.data_structures.tree;

/**
 * https://leetcode.com/problems/minimum-depth-of-binary-tree/
 * Given a binary tree, find its minimum depth.
 *
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Given binary tree [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * return its minimum depth = 2.
 */
public class MinimumDepthOfBinaryTree {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int[] minDepth = new int[1];
        minDepth[0] = Integer.MAX_VALUE;
        dfs(root, 1, minDepth);
        return minDepth[0];
    }

    private void dfs(TreeNode root, int depth, int[] minDepth) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            minDepth[0] = Math.min(minDepth[0], depth);
        }
        dfs(root.left, depth + 1, minDepth);
        dfs(root.right, depth + 1, minDepth);
    }
}
