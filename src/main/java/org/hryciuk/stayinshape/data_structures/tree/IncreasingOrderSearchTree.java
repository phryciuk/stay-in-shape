package org.hryciuk.stayinshape.data_structures.tree;

/**
 * 897. Increasing Order Search Tree
 * Easy
 *
 * Given a binary search tree, rearrange the tree in in-order so that the leftmost node in the tree is now the root of the tree, and every node has no left child and only 1 right child.
 *
 * Example 1:
 * Input: [5,3,6,2,4,null,8,1,null,null,null,7,9]
 *
 *        5
 *       / \
 *     3    6
 *    / \    \
 *   2   4    8
 *  /        / \
 * 1        7   9
 *
 * Output: [1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
 *
 *  1
 *   \
 *    2
 *     \
 *      3
 *       \
 *        4
 *         \
 *          5
 *           \
 *            6
 *             \
 *              7
 *               \
 *                8
 *                 \
 *                  9
 *
 *
 *
 * Constraints:
 *
 *     The number of nodes in the given tree will be between 1 and 100.
 *     Each node will have a unique integer value from 0 to 1000.
 */
public class IncreasingOrderSearchTree {
    public TreeNode increasingBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            return root;
        }
        if (root.left == null) {
            TreeNode rightSubtree = increasingBST(root.right);
            root.right = rightSubtree;
            return root;
        }
        if (root.right == null) {
            TreeNode newRoot = new TreeNode(root.left.val);
            root.left = null;
            newRoot.right = root;
            return newRoot;
        }
        TreeNode leftSubtree = increasingBST(root.left);
        TreeNode innerMostElement = leftSubtree;
        while (innerMostElement.right != null) {
            innerMostElement = innerMostElement.right;
        }
        root.left = null;
        innerMostElement.right = root;
        innerMostElement = innerMostElement.right;
        TreeNode rightSubtree = increasingBST(root.right);
        innerMostElement.right = rightSubtree;
        return leftSubtree;
    }
}
