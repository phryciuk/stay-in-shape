package org.hryciuk.stayinshape.data_structures.tree;

public class ConvertSortedArrayToBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return createBST(nums, 0, nums.length - 1);
    }

    public TreeNode createBST(int[] nums, int lo, int hi) {
        if (lo > hi) {
            return null;
        }
        int mid = lo + (hi - lo) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = createBST(nums, lo, mid - 1);
        root.right = createBST(nums, mid + 1, hi);
        return root;
    }
}
