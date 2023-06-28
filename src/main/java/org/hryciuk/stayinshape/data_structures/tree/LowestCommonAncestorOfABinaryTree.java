package org.hryciuk.stayinshape.data_structures.tree;

import java.util.LinkedList;

/*
    Video lesson: https://www.youtube.com/watch?v=KobQcxdaZKY
 */
public class LowestCommonAncestorOfABinaryTree {

    public TreeNode lowestCommonAncestorSimplest(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null ) {
            return null;
        }
        // if root is onf of the values, then LCA is root
        if (root == p || root == q) {
            return root;
        }
        // we do the DFS
        TreeNode left = lowestCommonAncestorSimplest(root.left, p, q);
        TreeNode right = lowestCommonAncestorSimplest(root.right, p, q);
        // if both of the results are not null, then root is LCA
        if (left != null && right != null) {
            return root;
        }
        // if only one of the branches returns something
        return left != null ? left : right;
    }


    public TreeNode lowestCommonAncestorSimpler(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        LinkedList<TreeNode> pPath = new LinkedList<>();
        LinkedList<TreeNode> qPath = new LinkedList<>();
        hasPath(root, p, pPath);
        hasPath(root, q, qPath);
        int index = 0;
        while (index < pPath.size() && index < qPath.size()) {
            TreeNode pCurrent = pPath.get(index);
            TreeNode qCurrent = qPath.get(index);
            if (pCurrent != qCurrent) {
                break;
            }
            index++;
        }
        return pPath.get(index - 1);
    }

    private boolean hasPath(TreeNode root, TreeNode toFind, LinkedList<TreeNode> path) {
        if (root == null) {
            return false;
        }
        if (root == toFind) {
            path.addFirst(root);
            return true;
        }
        boolean left = hasPath(root.left, toFind, path);
        boolean right = hasPath(root.right, toFind, path);
        if (left || right) {
            path.addFirst(root);
            return true;
        }
        return false;
    }


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
