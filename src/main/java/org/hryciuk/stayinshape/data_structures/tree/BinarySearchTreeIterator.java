package org.hryciuk.stayinshape.data_structures.tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 173. Binary Search Tree Iterator
 * Medium
 * https://leetcode.com/problems/binary-search-tree-iterator/
 * Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.
 *
 * Calling next() will return the next smallest number in the BST.
 *
 *
 *
 * Example:
 *
 * BSTIterator iterator = new BSTIterator(root);
 * iterator.next();    // return 3
 * iterator.next();    // return 7
 * iterator.hasNext(); // return true
 * iterator.next();    // return 9
 * iterator.hasNext(); // return true
 * iterator.next();    // return 15
 * iterator.hasNext(); // return true
 * iterator.next();    // return 20
 * iterator.hasNext(); // return false
 *
 *
 *
 * Note:
 *
 *     next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
 *     You may assume that next() call will always be valid, that is, there will be at least a next smallest number in the BST when next() is called
 */
public class BinarySearchTreeIterator {

    Deque<TreeNode> stack;

    public BinarySearchTreeIterator(TreeNode root) {
        this.stack = new LinkedList<>();
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    /** @return the next smallest number */
    public int next() {
        if (hasNext()) {
            TreeNode popped = stack.pop();
            if (popped.right != null) {
                TreeNode current = popped.right;
                while (current != null) {
                    stack.push(current);
                    current = current.left;
                }
            }
            return popped.val;
        }
        return -1;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

}
