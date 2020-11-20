package org.hryciuk.stayinshape.data_structures.tree;

public class FindACorrespondingNodeOfABinaryTreeInACloneOfThatTree {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (original == null) {
            return null;
        }
        if (original.left == null && original.right == null) {
            return cloned;
        }
        return dfs(original, cloned, target);
    }

    private TreeNode dfs(TreeNode original, TreeNode cloned, TreeNode target) {
        if (cloned == null) {
            return null;
        }
        TreeNode left = dfs(original.left, cloned.left, target);
        if (cloned.val == target.val) {
            return cloned;
        }
        TreeNode right = dfs(original.right, cloned.right, target);
        return left == null ? right : left;
    }
}
