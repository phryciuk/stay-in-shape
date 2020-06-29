package org.hryciuk.stayinshape.data_structures.tree;

/**
 * 538. Convert BST to Greater Tree
 * Easy
 *
 * Given a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST is changed to the original key plus sum of all keys greater than the original key in BST.
 *
 * Example:
 *
 * Input: The root of a Binary Search Tree like this:
 *               5
 *             /   \
 *            2     13
 *
 * Output: The root of a Greater Tree like this:
 *              18
 *             /   \
 *           20     13
 *
 * Note: This question is the same as 1038: https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/
 */
public class ConvertBSTToGreaterTree {

    // Traverse tree in reverse in-order direction and keep track of sum of already visited elements
    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        dfsImproved(root, 0);
        return root;
    }

    int dfsImproved(TreeNode root, int sum) {
        if (root == null) {
            return sum;
        }
        int right = dfsImproved(root.right, sum);
        int left = dfsImproved(root.left, root.val + right);
        root.val += right;
        return left;
    }

    TreeNode dfs(TreeNode root, TreeNode current) {
        if (current == null) {
            return null;
        }
        TreeNode left = dfs(root, current.left);
        TreeNode right = dfs(root, current.right);

        int sum = sumOfGreaterNodes(root, current.val);
        TreeNode newOne = new TreeNode(sum + current.val);
        newOne.left = left;
        newOne.right = right;
        return newOne;
    }

    int sumOfGreaterNodes(TreeNode root, int threshold) {
        if (root == null) {
            return 0;
        }
        int partialSum = 0;
        if (threshold >= root.val) {
            partialSum += sumOfGreaterNodes(root.right, threshold);
        } else {
            partialSum += root.val;
            partialSum += sumOfGreaterNodes(root.left, threshold);
            partialSum += sumOfGreaterNodes(root.right, threshold);
        }
        return partialSum;
    }
}
