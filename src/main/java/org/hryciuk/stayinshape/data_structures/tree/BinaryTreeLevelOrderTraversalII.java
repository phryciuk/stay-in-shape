package org.hryciuk.stayinshape.data_structures.tree;

import java.util.*;

/**
 * 107. Binary Tree Level Order Traversal II
 * Easy
 *
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * return its bottom-up level order traversal as:
 *
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 */
public class BinaryTreeLevelOrderTraversalII {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            List<Integer> levelList = new ArrayList<>();
            int size = q.size();
            for (int i = 0; i < size; ++i) {
                TreeNode polled = q.poll();
                levelList.add(polled.val);
                if (polled.left != null) {
                    q.offer(polled.left);
                }
                if (polled.right != null) {
                    q.offer(polled.right);
                }
            }
            result.add(levelList);
        }
        reverse(result);
        return result;
    }

    void reverse(List<List<Integer>> list) {
        for (int i = 0; i < list.size() / 2; ++i) {
            List<Integer> head = list.get(i);
            List<Integer> tail = list.get(list.size() - 1 - i);
            List<Integer> tmp = head;
            list.set(i, tail);
            list.set(list.size() - 1 - i, tmp);
        }
    }
    public List<List<Integer>> levelOrderBottomWithStack(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> q = new LinkedList<>();
        q.push(root);

        Deque<List<Integer>> stack = new LinkedList<>();
        while(!q.isEmpty()) {
            int size = q.size();
            List<Integer> level = new LinkedList<>();
            for (int i = 0; i < size; ++i) {
                TreeNode polled = q.poll();
                if (polled.left != null) {
                    q.offer(polled.left);
                }
                if (polled.right != null) {
                    q.offer(polled.right);
                }
                level.add(polled.val);
            }
            stack.push(level);
        }

        while(!stack.isEmpty()) {
            result.add(stack.pop());
        }
        return result;
    }


}
