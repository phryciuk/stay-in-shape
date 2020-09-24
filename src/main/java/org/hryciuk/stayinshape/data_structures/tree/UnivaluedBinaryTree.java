package org.hryciuk.stayinshape.data_structures.tree;

/**
 * 965. Univalued Binary Tree
 * Easy
 *
 * A binary tree is univalued if every node in the tree has the same value.
 *
 * Return true if and only if the given tree is univalued.
 *
 *
 *
 * Example 1:
 *
 * Input: [1,1,1,1,1,null,1]
 * Output: true
 *
 * Example 2:
 *
 * Input: [2,2,2,5,2]
 * Output: false
 *
 *
 *
 * Note:
 *
 *     The number of nodes in the given tree will be in the range [1, 100].
 *     Each node's value will be an integer in the range [0, 99].
 */
public class UnivaluedBinaryTree {

    public boolean isUnivalTree2(TreeNode root) {
        if (root == null) {
            return false;
        }
        int expectedVal = root.val;
        return dfs(root, expectedVal);
    }

    private boolean dfs(TreeNode root, int expectedVal) {
        if (root == null) {
            return true;
        }
        boolean left = dfs(root.left, expectedVal);
        if (root.val != expectedVal) {
            return false;
        }
        boolean right = dfs(root.right, expectedVal);
        return left && right;
    }

    public boolean isUnivalTree(TreeNode root) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return isUnival(root, root.val);
        }
        boolean isLeftUnival = isUnival(root.left, root.val);
        boolean isRootUnival = isUnival(root, root.val);
        boolean isRightUnival = isUnival(root.right, root.val);
        return isLeftUnival && isRightUnival && isRootUnival;
    }

    private boolean isUnival(TreeNode node, int val) {
        if (node == null) {
            return true;
        }
        if (node.left == null && node.right == null) {
            return node.val == val;
        }
        if (node.left == null) {
            return node.val == val && node.right.val == val && isUnival(node.right, val);
        }
        if (node.right == null) {
            return node.val == val && node.left.val == val && isUnival(node.left, val);
        }
        return node.val == val && isUnival(node.left, val) && isUnival(node.right, val);
    }
}
