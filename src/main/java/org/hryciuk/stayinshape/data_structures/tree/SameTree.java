package org.hryciuk.stayinshape.data_structures.tree;

/**
 * 100. Same Tree
 * Easy
 *
 * Given two binary trees, write a function to check if they are the same or not.
 *
 * Two binary trees are considered the same if they are structurally identical and the nodes have the same value.
 *
 * Example 1:
 *
 * Input:     1         1
 *           / \       / \
 *          2   3     2   3
 *
 *         [1,2,3],   [1,2,3]
 *
 * Output: true
 *
 * Example 2:
 *
 * Input:     1         1
 *           /           \
 *          2             2
 *
 *         [1,2],     [1,null,2]
 *
 * Output: false
 *
 * Example 3:
 *
 * Input:     1         1
 *           / \       / \
 *          2   1     1   2
 *
 *         [1,2,1],   [1,1,2]
 *
 * Output: false
 */
public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return dfs(p, q);
    }

    private boolean dfs(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        boolean sameLeftSubtrees = true;
        boolean sameRightSubtrees = true;
        if (p.left != null && q.left != null) {
            sameLeftSubtrees = dfs(p.left, q.left);
        } else if (p.left != null || q.left != null) {
            return false;
        }
        if (p.right != null && q.right != null) {
            sameRightSubtrees = dfs(p.right, q.right);
        } else if (p.right != null || q.right != null) {
            return false;
        }
        return sameLeftSubtrees && sameRightSubtrees && p.val == q.val;
    }
}
