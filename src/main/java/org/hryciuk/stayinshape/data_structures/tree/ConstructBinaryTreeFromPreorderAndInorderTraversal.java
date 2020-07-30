package org.hryciuk.stayinshape.data_structures.tree;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null && inorder == null) {
            return null;
        }
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        TreeNode root = helper(preorder, inorder, 0, 0, inorder.length - 1);
        return root;
    }

    private TreeNode helper(int[] preorder, int[] inorder, int preStart, int inStart, int inEnd) {
        if (preStart > preorder.length - 1 || inStart > inEnd) {
            return null;
        }
        // first element in the preorder is the root
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);

        // we look for the root in inorder array
        int rootIndexInInorder = -1;
        for (int i = 0; i < inorder.length; ++i) {
            if (inorder[i] == rootVal) {
                rootIndexInInorder = i;
            }
        }

        // everything to the left of the root index in inorder array is left subtree of the root;
        // everything to the right is the right subtree of the root
        // In Preorder, left node is immediately after the root node
        root.left = helper(preorder, inorder, preStart + 1, inStart, rootIndexInInorder - 1);
        root.right = helper(preorder, inorder, preStart + rootIndexInInorder - inStart + 1, rootIndexInInorder + 1, inEnd);
        return root;
    }

}
