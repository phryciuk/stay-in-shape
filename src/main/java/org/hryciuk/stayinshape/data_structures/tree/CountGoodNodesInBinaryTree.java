package org.hryciuk.stayinshape.data_structures.tree;

public class CountGoodNodesInBinaryTree {
    public int goodNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int max = root.val;
        return helper(root, max);
    }

    private int helper(TreeNode root, int max) {
        if (root == null) {
            return 0;
        }
        int count = 0;
        if (max <= root.val) {
            count++;
        }
        max = Math.max(max, root.val);
        int left = helper(root.left, max);
        int right = helper(root.right, max);
        return count + left + right;
    }
}
