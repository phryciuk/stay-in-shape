package org.hryciuk.stayinshape.data_structures.tree;

public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode invertedLeft = invertTree(root.left);
        TreeNode invertedRight = invertTree(root.right);
        root.left = invertedRight;
        root.right = invertedLeft;
        return root;
    }
}
