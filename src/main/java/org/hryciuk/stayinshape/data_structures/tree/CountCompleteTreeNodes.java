package org.hryciuk.stayinshape.data_structures.tree;

/**
 * 222. Count Complete Tree Nodes
 * Medium
 * https://leetcode.com/problems/count-complete-tree-nodes/
 * Given a complete binary tree, count the number of nodes.
 *
 * Note:
 *
 * Definition of a complete binary tree from Wikipedia:
 * In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.
 *
 * Example:
 *
 * Input:
 *     1
 *    / \
 *   2   3
 *  / \  /
 * 4  5 6
 *
 * Output: 6
 *
 * Accepted
 * 231,819
 * Submissions
 * 506,757
 */
public class CountCompleteTreeNodes {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftSubtree = countNodes(root.left);
        int rightSubtree = countNodes(root.right);
        return leftSubtree + rightSubtree + 1;
    }
}
