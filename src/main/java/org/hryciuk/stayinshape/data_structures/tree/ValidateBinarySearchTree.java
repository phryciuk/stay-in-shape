package org.hryciuk.stayinshape.data_structures.tree;

import java.util.Deque;
import java.util.LinkedList;

public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            return true;
        }
        return isValid(root, null, null);
    }

    private boolean isValid(TreeNode root, Integer lo, Integer hi) {
        if (root == null) {
            return true;
        }
        if (lo != null && root.val <= lo) {
            return false;
        }
        if (hi != null && root.val >= hi) {
            return false;
        }
        return isValid(root.left, lo, root.val)
                && isValid(root.right, root.val, hi);
    }

    public boolean validateInOrder(TreeNode root) {
        if (root == null) {
            return true;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        return isItBinarySearchTree(root, deque);
    }

    private boolean isItBinarySearchTree(TreeNode root, Deque<TreeNode> deque) {
        if (root == null) {
            return true;
        }
        boolean left = isItBinarySearchTree(root.left, deque);
        if (deque.isEmpty()) {
            deque.add(root);
        } else {
            if (deque.peekLast().val >= root.val) {
                return false;
            } else {
                deque.add(root);
            }
        }
        boolean right = isItBinarySearchTree(root.right, deque);
        return left && right;
    }
}
