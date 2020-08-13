package org.hryciuk.stayinshape.data_structures.tree;

public class BinaryTreePruning {

    public TreeNode pruneTreeSimpler(TreeNode root) {
        if (root == null) {
            return null;
        }
        root.left = pruneTreeSimpler(root.left);
        root.right = pruneTreeSimpler(root.right);
        return root.left == null && root.right == null && root.val == 0 ? null : root;
    }

    public TreeNode pruneTree(TreeNode root) {
        dfs(root, null, SIDE.LEFT);
        // additional check for root, since it doesn't have any prev element;
        if (shouldBePruned(root)) {
            return null;
        }
        return root;
    }

    private void dfs(TreeNode root, TreeNode prev, SIDE side) {
        if (root == null) {
            return;
        }
        dfs(root.left, root, SIDE.LEFT);
        if (shouldBePruned(root)) {
            if (prev != null) {
                if (SIDE.LEFT == side) {
                    prev.left = null;
                } else {
                    prev.right = null;
                }
            } else {
                // the whole subtree is zeroes.
                 return;
            }
        }
        dfs(root.right, root, SIDE.RIGHT);
    }

    private boolean shouldBePruned(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.val == 1) {
            return false;
        }
        boolean leftSubtree = shouldBePruned(root.left);
        boolean rightSubtree = shouldBePruned(root.right);
        return leftSubtree && rightSubtree && root.val == 0;
    }

    enum SIDE {
        LEFT,
        RIGHT;
    }
}
