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

    public boolean isSymmetricA(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            return true;
        }
        if (root.left == null || root.right == null) {
            return false;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode leftSubtree = root.left;
        TreeNode rightSubtree = root.right;
        while ((leftSubtree != null && rightSubtree != null) || !stack.isEmpty()) {
            if (leftSubtree != null && rightSubtree != null) {
                stack.push(leftSubtree);
                stack.push(rightSubtree);
                leftSubtree = leftSubtree.left;
                rightSubtree = rightSubtree.right;
            } else if (leftSubtree == null && rightSubtree == null) {
                TreeNode firstOne = stack.pop();
                TreeNode secondOne = stack.pop();
                if (firstOne.val != secondOne.val) {
                    return false;
                }
                leftSubtree = firstOne.right;
                rightSubtree = secondOne.left;
            } else {
                return false;
            }
        }
        return true;
    }


}
