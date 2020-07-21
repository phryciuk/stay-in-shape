package org.hryciuk.stayinshape.data_structures.tree;

/**
 * 110. Balanced Binary Tree
 * Easy
 * https://leetcode.com/problems/balanced-binary-tree/
 * Given a binary tree, determine if it is height-balanced.
 *
 * For this problem, a height-balanced binary tree is defined as:
 *
 *     a binary tree in which the left and right subtrees of every node differ in height by no more than 1.
 *
 *
 *
 * Example 1:
 *
 * Given the following tree [3,9,20,null,null,15,7]:
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * Return true.
 *
 * Example 2:
 *
 * Given the following tree [1,2,2,3,3,null,null,4,4]:
 *
 *        1
 *       / \
 *      2   2
 *     / \
 *    3   3
 *   / \
 *  4   4
 *
 * Return false.
 */
public class BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean[] isNonBalanced = new boolean[1];
        int left = height(root.left, isNonBalanced);
        int right = height(root.right, isNonBalanced);
        if (Math.abs(left - right) > 1) {
            return false;
        }
        return !isNonBalanced[0];
    }

    int height(TreeNode root, boolean[] isNonBalanced) {
        if (root == null ) {
            return 0;
        }
        int left = height(root.left, isNonBalanced);
        int right = height(root.right, isNonBalanced);
        if (Math.abs(left - right) > 1) {
            isNonBalanced[0] = true;
        }
        return Math.max(left, right) + 1;
    }
}
