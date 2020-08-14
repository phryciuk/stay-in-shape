package org.hryciuk.stayinshape.data_structures.tree;

/**
 * https://www.geeksforgeeks.org/find-count-of-singly-subtrees/
 * Given a binary tree, write a program to count the number of Single Valued Subtrees. A Single Valued Subtree is one in which all the nodes have same value. Expected time complexity is O(n).
 *
 * Example:
 *
 * Input: root of below tree
 *               5
 *              / \
 *             1   5
 *            / \   \
 *           5   5   5
 * Output: 4
 * There are 4 subtrees with single values.
 *
 *
 * Input: root of below tree
 *               5
 *              / \
 *             4   5
 *            / \   \
 *           4   4   5
 * Output: 5
 * There are five subtrees with single values.
 */
public class SingleValuedSubtrees {
    public int singleValuedSubtrees(TreeNode root) {
        int result = 0;
        int[] numberOfSubtrees = new int[1];
        if (root == null) {
            return result;
        }
        isUnivalued(root, numberOfSubtrees);
        return numberOfSubtrees[0];
    }

    private boolean isUnivalued(TreeNode root, int[] numberOfSubtrees) {
        if (root == null) {
            return true;
        }
        boolean left = isUnivalued(root.left, numberOfSubtrees);
        boolean right = isUnivalued(root.right, numberOfSubtrees);
        if (root.left == null && root.right == null) {
            numberOfSubtrees[0]++;
            return true;
        } else if (root.left != null && root.right != null) {
            if (left && root.left.val == root.val && right && root.right.val == root.val) {
                numberOfSubtrees[0]++;
                return true;
            }
        } else if (root.left != null) {
            if (left && root.left.val == root.val) {
                numberOfSubtrees[0]++;
                return true;
            }
        } else {
            if (right && root.right.val == root.val) {
                numberOfSubtrees[0]++;
                return true;
            }
        }
        return false;
    }
}
