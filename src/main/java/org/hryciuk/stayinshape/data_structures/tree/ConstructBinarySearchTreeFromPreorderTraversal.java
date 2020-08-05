package org.hryciuk.stayinshape.data_structures.tree;

/**
 * 1008. Construct Binary Search Tree from Preorder Traversal
 * Medium
 *
 * Return the root node of a binary search tree that matches the given preorder traversal.
 *
 * (Recall that a binary search tree is a binary tree where for every node, any descendant of node.left has a value < node.val, and any descendant of node.right has a value > node.val.  Also recall that a preorder traversal displays the value of the node first, then traverses node.left, then traverses node.right.)
 *
 * It's guaranteed that for the given test cases there is always possible to find a binary search tree with the given requirements.
 *
 * Example 1:
 *
 * Input: [8,5,1,7,10,12]
 * Output: [8,5,10,1,7,null,12]
 *
 *
 *
 * Constraints:
 *
 *     1 <= preorder.length <= 100
 *     1 <= preorder[i] <= 10^8
 *     The values of preorder are distinct.
 *
 * Accepted
 * 132,635
 * Submissions
 * 169,195
 */
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
