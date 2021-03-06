package org.hryciuk.stayinshape.data_structures.tree;

import java.util.Stack;

/**
 * 938. Range Sum of BST
 * Easy
 *
 * Given the root node of a binary search tree, return the sum of values of all nodes with value between L and R (inclusive).
 *
 * The binary search tree is guaranteed to have unique values.
 *
 *
 *
 * Example 1:
 *
 * Input: root = [10,5,15,3,7,null,18], L = 7, R = 15
 * Output: 32
 *
 * Example 2:
 *
 * Input: root = [10,5,15,3,7,13,18,1,null,6], L = 6, R = 10
 * Output: 23
 *
 *
 *
 * Note:
 *
 *     The number of nodes in the tree is at most 10000.
 *     The final answer is guaranteed to be less than 2^31.
 */
public class RangeSumOfBst {
    public int rangeSumBST(TreeNode root, int L, int R) {
        int result = 0;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            if (current.left != null) {
                stack.push(current.left);
            }
            if (current.val >= L && current.val <= R) {
                result += current.val;
            }
            if (current.right != null) {
                stack.push(current.right);
            }
        }
        return result;
    }
}
