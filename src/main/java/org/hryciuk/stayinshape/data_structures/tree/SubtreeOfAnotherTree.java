package org.hryciuk.stayinshape.data_structures.tree;

public class SubtreeOfAnotherTree {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        return inorderDfs(s, t);
    }

    private boolean inorderDfs(TreeNode s, TreeNode t) {
        if (s == null) {
            return false;
        }
        boolean left = inorderDfs(s.left, t);
        if (s.val == t.val) {
            boolean result = isIdenticalSubtree(s, t);
            if (result) {
                return true;
            }
        }
        boolean right = inorderDfs(s.right, t);
        return left || right;
    }

    private boolean isIdenticalSubtree(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        boolean left = isIdenticalSubtree(s.left, t.left);
        if (s.val != t.val) {
            return false;
        }
        boolean right = isIdenticalSubtree(s.right, t.right);
        return left && right;
    }
}
