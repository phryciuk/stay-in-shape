package org.hryciuk.stayinshape.data_structures.tree;

public class DiameterOfBinaryTree {
    int diameter = 0;


    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return diameter;
        }
        diameter(root);
        return diameter;
    }

    int diameter(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = diameter(root.left);
        int right = diameter(root.right);
        // longest diameter of any subtree
        diameter = Math.max(diameter, left + right);
        // we return longer subtree
        int longestDiameter = Math.max(left, right);
        return longestDiameter + 1;
    }
}
