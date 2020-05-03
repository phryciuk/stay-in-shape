package org.hryciuk.stayinshape.data_structures.tree;

import java.util.Stack;

/**
 * 617. Merge Two Binary Trees
 * Easy
 *
 * Given two binary trees and imagine that when you put one of them to cover the other,
 * some nodes of the two trees are overlapped while the others are not.
 *
 * You need to merge them into a new binary tree. The merge rule is that if two nodes overlap,
 * then sum node values up as the new value of the merged node. Otherwise, the NOT null node will be used as the node of new tree.
 *
 * Example 1:
 *
 * Input:
 * 	Tree 1                     Tree 2
 *           1                         2
 *          / \                       / \
 *         3   2                     1   3
 *        /                           \   \
 *       5                             4   7
 * Output:
 * Merged tree:
 * 	     3
 * 	    / \
 * 	   4   5
 * 	  / \   \
 * 	 5   4   7
 *
 *
 *
 * Note: The merging process must start from the root nodes of both trees.
 */
public class MergeTwoBinaryTrees {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        Stack<TreeNode> stack = new Stack<>();
        if (t1 != null && t2 != null) {
            stack.push(t2);
            stack.push(t1);
        } else if (t1 != null) {
            return t1;
        } else {
            return t2;
        }

        while (!stack.isEmpty()) {
            TreeNode firstRoot = stack.pop();
            TreeNode secondRoot = stack.pop();
            if (firstRoot == null && secondRoot == null) {
                continue;
            }
            int sumOfRootValues = (firstRoot != null ? firstRoot.val : 0) + (secondRoot != null ? secondRoot.val : 0);
            if (firstRoot == null) {
                firstRoot = secondRoot;
            }
            firstRoot.val = sumOfRootValues;
            if (firstRoot.left == null) {
                firstRoot.left = secondRoot != null ? secondRoot.left : null;
            }
            stack.push(secondRoot != null ? secondRoot.left : null);
            stack.push(firstRoot.left);
            if (firstRoot.right == null) {
                firstRoot.right = secondRoot != null ? secondRoot.right : null;

            }

        }
        return t2;
    }
}