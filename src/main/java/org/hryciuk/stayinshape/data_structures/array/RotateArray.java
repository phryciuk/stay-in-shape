package org.hryciuk.stayinshape.data_structures.array;

public class RotateArray {

    // Time complexity: O(n)
    // Space complexity: O(1)
    public void rotate(int[] nums, int k) {
        int lastIndex = nums.length - 1;
        k = k % nums.length;  // this avoids a scenario where k > nums.length
        reverse(nums, 0, lastIndex);
        reverse(nums, 0, k - 1);
        reverse(nums, k, lastIndex);
    }

    // i and j are inclusive
    private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}

