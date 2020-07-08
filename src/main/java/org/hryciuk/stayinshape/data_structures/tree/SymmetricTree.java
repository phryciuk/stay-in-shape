package org.hryciuk.stayinshape.data_structures.tree;

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            return true;
        }
        return dfsHelper(root.left, root.right);
    }

    boolean dfsHelper(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        boolean first = dfsHelper(left.left, right.right);
        if (left.val != right.val) {
            return false;
        }
        boolean second = dfsHelper(left.right, right.left);
        return first && second;
    }
}
