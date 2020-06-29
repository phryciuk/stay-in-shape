package org.hryciuk.stayinshape.data_structures.tree;

import java.util.HashSet;
import java.util.Set;

/**
 * 653. Two Sum IV - Input is a BST
 * Easy
 *
 * Given a Binary Search Tree and a target number, return true if there exist two elements in the BST such that their sum is equal to the given target.
 */
public class TwoSumIV {
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        Set<Integer> set = new HashSet<>();
        return dfs(root, k, set);
    }

    private boolean dfs(TreeNode root, int target, Set<Integer> set) {
        if (root == null) {
            return false;
        }
        if (set.contains(target - root.val)) {
            return true;
        }
        set.add(root.val);
        boolean left = dfs(root.left, target, set);
        boolean right = dfs(root.right, target, set);
        return left || right;
    }
}
