package org.hryciuk.stayinshape.data_structures.tree;

/**
 * https://leetcode.com/problems/deepest-leaves-sum/
 * 1302. Deepest Leaves Sum
 * Medium
 * Given a binary tree, return the sum of values of its deepest leaves.
 *
 * Example 1:
 *
 * Input: root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
 * Output: 15
 *
 * Constraints:
 *
 *     The number of nodes in the tree is between 1 and 10^4.
 *     The value of nodes is between 1 and 100.
 */
public class DeepestLeavesSum {

    public int deepestLeavesSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int height = height(root);
        int result = dfs(root, 1, height);
        return result;
    }

    private int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftSubtreeHeight = height(root.left);
        int rightSubtreeHeight = height(root.right);
        int maxDepth = Math.max(leftSubtreeHeight + 1, rightSubtreeHeight + 1);
        return maxDepth;
    }

    private int dfs(TreeNode root, int currentHeight, int demandedDepth) {
        if (root == null) {
            return 0;
        }
        if (currentHeight == demandedDepth) {
            return root.val;
        }
        int leftSubtreeSum = dfs(root.left, currentHeight + 1, demandedDepth);
        int rightSubtreeSum = dfs(root.right, currentHeight + 1, demandedDepth);
        return leftSubtreeSum + rightSubtreeSum;
    }
}
