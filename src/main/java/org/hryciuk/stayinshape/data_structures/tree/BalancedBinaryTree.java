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
        boolean[] isBalanced = new boolean[]{true};
        height(root, isBalanced);
        return isBalanced[0];
    }

    int height(TreeNode root, boolean[] isBalanced) {
        if (root == null ) {
            return 0;
        }
        int left = height(root.left, isBalanced);
        int right = height(root.right, isBalanced);
        if (Math.abs(left - right) > 1) {
            isBalanced[0] = false;
        }
        return Math.max(left, right) + 1;
    }
}
