package org.hryciuk.stayinshape.data_structures.tree;

public class MaxPathSum {
    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return root.val;
        }
        int[] maxPathSum = new int[]{-1001};
        findMaxSumAsBranch(root, maxPathSum);
        return maxPathSum[0];
    }
    private int findMaxSumAsBranch(TreeNode root, int[] maxPathSum) {
        if (root == null) {
            return -1001;
        }
        int left = findMaxSumAsBranch(root.left, maxPathSum);
        int right = findMaxSumAsBranch(root.right, maxPathSum);
        int maxChildSumAsBranch = Math.max(left, right);
        int maxSumAsBranch = Math.max(maxChildSumAsBranch + root.val, root.val);
        int maxSumAsRootNode = Math.max(left + right + root.val, maxSumAsBranch);
        maxPathSum[0] = Math.max(maxPathSum[0], maxSumAsRootNode);
        return maxSumAsBranch;
    }
    // O(n) time | O(log(n)) space


}
