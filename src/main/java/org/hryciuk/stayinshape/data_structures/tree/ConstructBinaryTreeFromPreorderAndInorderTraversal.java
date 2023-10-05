package org.hryciuk.stayinshape.data_structures.tree;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null) {
            return null;
        }
        Map<Integer, Integer> indices = new HashMap<>();
        // we create a hashmap with mapping between index and value
        for (int i = 0; i < inorder.length; ++i) {
            indices.put(inorder[i], i);
        }
        TreeNode root = helper(preorder, inorder, 0, 0, inorder.length - 1, indices);
        return root;
    }

    private TreeNode helper(int[] preorder, int[] inorder, int preStart, int inStart, int inEnd, Map<Integer, Integer> map) {
        if (preStart > preorder.length - 1 || inStart > inEnd) {
            return null;
        }
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);

        int inMid = map.get(rootVal);

        root.left = helper(preorder, inorder, preStart + 1, inStart, inMid - 1, map);
        // preStart + mid - inStart + 1 is prestart + (r - l + 1). this is a start for the right subtree
        root.right = helper(preorder, inorder, preStart + inMid - inStart + 1, inMid + 1, inEnd, map);
        return root;
    }

}
