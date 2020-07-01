package org.hryciuk.stayinshape.data_structures.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 404. Sum of Left Leaves
 * Easy
 *
 * Find the sum of all left leaves in a given binary tree.
 *
 * Example:
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
 */
public class SumOfLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        int sum = 0;
        while (!q.isEmpty()) {
            TreeNode polled = q.poll();
            if (polled.left != null) {
                if (polled.left.left == null && polled.left.right == null) {
                    sum += polled.left.val;
                }
            }
            if (polled.left != null) {
                q.offer(polled.left);
            }
            if (polled.right != null) {
                q.offer(polled.right);
            }
        }
        return sum;
    }
}
