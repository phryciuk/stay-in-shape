package org.hryciuk.stayinshape.data_structures.tree;

import java.util.Stack;

public class SymmetricTree {

    public boolean isSymmetricIteratively(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            return true;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode first = root.left;
        TreeNode second = root.right;
        while ((second != null && first != null) || !stack.isEmpty()) {
            if (second != null && first != null) {
                stack.push(second);
                stack.push(first);
                first = first.left;
                second = second.right;
            } else if (second == null && first == null) {
                TreeNode firstPopped = stack.pop();
                TreeNode secondPopped = stack.pop();
                if (firstPopped.val != secondPopped.val) {
                    return false;
                }
                first = firstPopped.right;
                second = secondPopped.left;
            } else { // case where there is one child only
                return false;
            }
        }
        return second == first; // [1,2] case
    }

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
