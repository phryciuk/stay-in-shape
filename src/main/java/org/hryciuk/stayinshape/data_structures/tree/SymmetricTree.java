package org.hryciuk.stayinshape.data_structures.tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * https://leetcode.com/problems/symmetric-tree/
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 *
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 *
 *
 *
 * But the following [1,2,2,null,3,null,3] is not:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *
 *
 *
 * Follow up: Solve it both recursively and iteratively.
 */
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

    public boolean isSymmetric2(TreeNode root) {
        if (root == null) {
            return true;
        } else if (root.left == null && root.right == null) {
            return true;
        } else if (root.left == null || root.right == null) {
            return false;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode left = root.left;
        TreeNode right = root.right;
        while ((left != null && right != null) || !stack.isEmpty()) {
            if (left != null && right != null) {
                stack.push(left);
                left = left.left;
                stack.push(right);
                right = right.right;
            } else if (left == null && right == null) {
                TreeNode first = stack.pop();
                if (!stack.isEmpty()) {
                    TreeNode second = stack.pop();
                    if (first.val != second.val) {
                        return false;
                    } else {
                        right = first.left;
                        left = second.right;
                    }
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        return left == right;
    }


}
