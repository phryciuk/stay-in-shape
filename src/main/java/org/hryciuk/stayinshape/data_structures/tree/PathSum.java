package org.hryciuk.stayinshape.data_structures.tree;

/**
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Given the below binary tree and sum = 22,
 *
 *       5
 *      / \
 *     4   8
 *    /   / \
 *   11  13  4
 *  /  \      \
 * 7    2      1
 *
 * return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 */
public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        return dfs(root, 0, sum);
    }

    private boolean dfs(TreeNode root, int sum, int wantedSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null && sum + root.val == wantedSum) {
            return true;
        }
        boolean left = dfs(root.left, sum + root.val, wantedSum);
        boolean right = dfs(root.right, sum + root.val, wantedSum);
        return left || right;
    }
}
