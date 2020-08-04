package org.hryciuk.stayinshape.data_structures.tree;

public class MaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        TreeNode root = buildMaxTree(nums, 0, nums.length);
        return root;
    }

    private TreeNode buildMaxTree(int[] nums, int start, int end) {
        if (start < 0 || end > nums.length || start >= end) {
            return null;
        }
        int maxIndex = findMaxIndex(start, end, nums);
        TreeNode root = new TreeNode(nums[maxIndex]);
        root.left = buildMaxTree(nums, start, maxIndex);
        root.right = buildMaxTree(nums, maxIndex + 1, end);
        return root;
    }

    private int findMaxIndex(int start, int end, int[] nums) {
        int max = start;
        for (int i = start; i < end; i++) {
            if (nums[i] > nums[max]) {
                max = i;
            }
        }
        return max;
    }
}
