package org.hryciuk.stayinshape.data_structures.tree;

public class ConstructBinarySearchTreeFromPreorderTraversal {
    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        TreeNode root = helper(preorder, 0, preorder.length);
        return root;
    }

    TreeNode helper(int[] preorder, int start, int end) {
        if (start < 0 || end > preorder.length || start >= end) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[start]);

        int rightSubtreeIndex = findRightSubtreeIndex(start, end, preorder);
        root.right = helper(preorder, rightSubtreeIndex, end);

        int leftSubtreeIndex = findLeftSubtreeIndex(start, end, preorder);
        if (leftSubtreeIndex != -1) {
            if (rightSubtreeIndex != -1) {
                root.left = helper(preorder, leftSubtreeIndex, rightSubtreeIndex);
            } else {
                root.left = helper(preorder, leftSubtreeIndex, end);
            }
        } else {
            root.left = null;
        }
        return root;
    }

    private int findRightSubtreeIndex(int start, int end, int[] preorder) {
        if (start >= end - 1) {
            return -1;
        }
        for (int i = start + 1; i < end; ++i) {
            if (preorder[i] > preorder[start]) {
                return i;
            }
        }
        return -1;
    }

    private int findLeftSubtreeIndex(int start, int end, int[] preorder) {
        if (start >= end - 1) {
            return -1;
        }
        for (int i = start + 1; i < end; ++i) {
            if (preorder[i] < preorder[start]) {
                return i;
            }
        }
        return -1;
    }
}
