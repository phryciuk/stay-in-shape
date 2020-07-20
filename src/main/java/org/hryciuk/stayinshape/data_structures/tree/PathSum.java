package org.hryciuk.stayinshape.data_structures.tree;

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
