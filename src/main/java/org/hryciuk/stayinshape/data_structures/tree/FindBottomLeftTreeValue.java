package org.hryciuk.stayinshape.data_structures.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/find-bottom-left-tree-value/
 * 513. Find Bottom Left Tree Value
 * Medium
 *
 * Given a binary tree, find the leftmost value in the last row of the tree.
 *
 * Example 1:
 *
 * Input:
 *
 *     2
 *    / \
 *   1   3
 *
 * Output:
 * 1
 *
 * Example 2:
 *
 * Input:
 *
 *         1
 *        / \
 *       2   3
 *      /   / \
 *     4   5   6
 *        /
 *       7
 *
 * Output:
 * 7
 *
 * Note: You may assume the tree (i.e., the given root node) is not NULL.
 */
public class FindBottomLeftTreeValue {
    public int findBottomLeftValue(TreeNode root) {
        if (root == null) {
            return -1;
        }
        if (root.left == null && root.right == null) {
            return root.val;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int leftmostValue = root.val;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; ++i) {
                TreeNode current = q.poll();
                if (i == 0) {
                    leftmostValue = current.val;
                }
                if (current.left != null) {
                    q.offer(current.left);
                }
                if (current.right != null) {
                    q.offer(current.right);
                }
            }
        }
        return leftmostValue;
    }
}
