package org.hryciuk.stayinshape.data_structures.tree;

public class LowestCommonAncestorOfABinaryTree {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val == p.val || root.val == q.val) {
            return root;
        }
        return dfs(root, p, q);
    }

    TreeNode dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        TreeNode foundInLeft = dfs(root.left, p, q);
        if (foundInLeft != null) {
            return foundInLeft;
        }
        TreeNode foundInRight = dfs(root.right, p, q);
        if (foundInRight != null) {
            return foundInRight;
        }
        if (isPresentInSubtree(root, p) && isPresentInSubtree(root, q)) {
            return root;
        }
        return null;
    }

    private boolean isPresentInSubtree(TreeNode root, TreeNode toFind) {
        if (root == null) {
            return false;
        }
        if (root.val == toFind.val) {
            return true;
        }
        boolean inLeft = isPresentInSubtree(root.left, toFind);
        boolean inRight = isPresentInSubtree(root.right, toFind);
        return inLeft || inRight;
    }
}
