package org.hryciuk.stayinshape.data_structures.tree;


import java.util.LinkedList;
import java.util.List;

/**
 * 872. Leaf-Similar Trees
 * Easy
 * https://leetcode.com/problems/leaf-similar-trees/
 * Consider all the leaves of a binary tree.  From left to right order, the values of those leaves form a leaf value sequence.
 *
 * For example, in the given tree above, the leaf value sequence is (6, 7, 4, 9, 8).
 *
 * Two binary trees are considered leaf-similar if their leaf value sequence is the same.
 *
 * Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar.
 *
 *
 *
 * Constraints:
 *
 *     Both of the given trees will have between 1 and 200 nodes.
 *     Both of the given trees will have values between 0 and 200
 */
public class LeafSimilarTrees {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        List<Integer> leftChildren = dfs(root1);
        List<Integer> rightChildren = dfs(root2);
        if (leftChildren.size() != rightChildren.size()) {
            return false;
        } else {
            for (int i = 0; i < leftChildren.size(); ++i) {
                if (!leftChildren.get(i).equals(rightChildren.get(i))) {
                    return false;
                }
            }
        }
        return true;
    }

    private List<Integer> dfs(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        if (root.left == null && root.right == null) {
            result.add(root.val);
            return result;
        }
        List<Integer> leftSubtree = dfs(root.left);
        List<Integer> rightSubtree = dfs(root.right);
        result.addAll(leftSubtree);
        result.addAll(rightSubtree);
        return result;
    }
}
