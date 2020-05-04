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

    // iterative
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }
        TreeNode[] pairOfNodes = new TreeNode[] {t1, t2};
        Stack<TreeNode[]> stack = new Stack<>();
        stack.push(pairOfNodes);
        while (!stack.isEmpty()) {
            TreeNode[] poppedPair = stack.pop();
            if (poppedPair[0] == null || poppedPair[1] == null) {
                continue;
            }
            int sum = poppedPair[0].val + poppedPair[1].val;
            poppedPair[0].val = sum;
            if (poppedPair[0].left == null) {
                poppedPair[0].left = poppedPair[1].left;
            } else {
                stack.push(new TreeNode[] {poppedPair[0].left, poppedPair[1].left});
            }
            if (poppedPair[0].right == null) {
                poppedPair[0].right = poppedPair[1].right;
            } else {
                stack.push(new TreeNode[] {poppedPair[0].right, poppedPair[1].right});
            }
        }
        return t1;
    }

    // recursive
    public TreeNode mergeTreesRecursively(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return null;
        }
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        int sum = (t1.val != null ? t1.val : 0) + (t2.val != null ? t2.val : 0);
        t1.val = sum;
        TreeNode leftSubtree = mergeTreesRecursively(t1.left, t2.left);
        TreeNode rightSubtree = mergeTreesRecursively(t1.right, t2.right);
        t1.left = leftSubtree;
        t1.right = rightSubtree;
        return t1;
    }

}