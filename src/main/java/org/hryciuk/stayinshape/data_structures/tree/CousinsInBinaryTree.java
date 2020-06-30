package org.hryciuk.stayinshape.data_structures.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 993. Cousins in Binary Tree
 * Easy
 *
 * In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.
 *
 * Two nodes of a binary tree are cousins if they have the same depth, but have different parents.
 *
 * We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.
 *
 * Return true if and only if the nodes corresponding to the values x and y are cousins.
 */
public class CousinsInBinaryTree {
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) {
            return false;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            boolean xFound = false;
            boolean yFound = false;
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                TreeNode polled = queue.poll();
                if (polled.left != null && polled.right != null) {
                    if (polled.left.val == x && polled.right.val == y) {
                        return false;
                    } else if (polled.left.val == y && polled.right.val == x) {
                        return false;
                    }
                }
                if (polled.val == x) {
                    xFound = true;
                }
                if (polled.val == y) {
                    yFound = true;
                }
                if (xFound && yFound) {
                    return true;
                }
                if (polled.left != null) {
                    queue.offer(polled.left);
                }
                if (polled.right != null) {
                    queue.offer(polled.right);
                }
            }
        }
        return false;
    }
}
