package org.hryciuk.stayinshape.data_structures.tree;

public class BinaryTreeTilt {
    public int findTilt(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int[] tilt = new int[1];
        dfsPostOrder(root, tilt);
        return tilt[0];
    }

    int dfsPostOrder(TreeNode root, int[] tilt) {
        if (root == null) {
            return 0;
        }
        int left = dfsPostOrder(root.left, tilt);
        int right = dfsPostOrder(root.right, tilt);
        tilt[0] += Math.abs(left - right);
        return left + right + root.val;
    }
}
