package org.hryciuk.stayinshape.data_structures.tree;

public class CountUnivalueSubtrees {

    public int countUnivalueSubtrees(TreeNode root) {
        int[] result = new int[1];
        if (root == null) {
            return result[0];
        }
        dfs(root, result);
        return result[0];
    }

    private void dfs(TreeNode root, int[] result) {
        if (root == null) {
            return;
        }
        dfs(root.left, result);
        if (isUnival(root, root.val)) {
            result[0]++;
        }
        dfs(root.right, result);
    }

    private boolean isUnival(TreeNode root, int expectedVal) {
        if (root == null) {
            return true;
        }
        boolean left = isUnival(root.left, expectedVal);
        if (root.val != expectedVal) {
            return false;
        }
        boolean right = isUnival(root.right, expectedVal);
        return left && right;
    }
}
