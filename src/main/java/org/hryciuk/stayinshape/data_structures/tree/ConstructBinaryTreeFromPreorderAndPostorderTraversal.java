package org.hryciuk.stayinshape.data_structures.tree;

public class ConstructBinaryTreeFromPreorderAndPostorderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null && postorder == null) {
            return null;
        }
        return helper(inorder, postorder, postorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] inorder, int[] postorder, int postStart, int inStart, int inEnd) {
        if (postStart < 0 || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postStart]);

        // find 'root' in the inorder array
        int index = -1;
        for (int i = 0; i < inorder.length; ++i) {
            if (inorder[i] == root.val) {
                index = i;
            }
        }
        root.left = helper(inorder, postorder, postStart - (inEnd - index) - 1, inStart, index -1);
        root.right = helper(inorder, postorder, postStart - 1, index + 1, inEnd);
        return root;
    }
}
