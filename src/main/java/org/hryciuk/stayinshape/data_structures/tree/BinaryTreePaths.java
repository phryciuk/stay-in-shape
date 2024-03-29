package org.hryciuk.stayinshape.data_structures.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 257. Binary Tree Paths
 * Easy
 *
 * Given a binary tree, return all root-to-leaf paths.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Input:
 *
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 *
 * Output: ["1->2->5", "1->3"]
 *
 * Explanation: All root-to-leaf paths are: 1->2->5, 1->3
 */
public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        dfs(root, "", result);
        return result;
    }

    private void dfs(TreeNode root, String current, List<String> result) {
        if (root == null) {
            return;
        }
        current += root.val;
        if (root.left == null && root.right == null) {
            result.add(current);
            return;
        }
        if (root.left != null) {
            dfs(root.left, current + "->", result);
        }
        if (root.right != null) {
            dfs(root.right, current + "->", result);
        }
    }
}
