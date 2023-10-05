package org.hryciuk.stayinshape.data_structures.tree;

public class SubtreeOfAnotherTree {
    public boolean isSubtree(TreeNode p, TreeNode q) {
        if (q == null) {
            return true;
        }
        if (p == null) {
            return false;
        }
        if (isSameTree(p, q)) {
            return true;
        }
        return isSubtree(p.left, q) || isSubtree(p.right, q);
    }

    private boolean isSameTree(TreeNode p, TreeNode q) {
        if (p != null && q != null && p.val == q.val) {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        } else if (p == null && q == null) {
            return true;
        }
        return false;
    }
}
