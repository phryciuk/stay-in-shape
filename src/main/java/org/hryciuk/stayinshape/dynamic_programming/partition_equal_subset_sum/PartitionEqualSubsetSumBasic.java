package org.hryciuk.stayinshape.dynamic_programming.partition_equal_subset_sum;

public class PartitionEqualSubsetSumBasic {

    // This solution is correct but very slow
    // Time complexity O(2 ^ n), where n represents total number
    // Space complexity O(n) - memory for storing recursion stack
    public boolean canPartition(int[] nums) {
        // first we need to calculate the sum of all the numbers and see if that is even number.
        // if it is odd then we cannot partition that to equal subsets.
        int sum = 0;
        for (int i = 0; i < nums.length; ++i) {
            sum += nums[i];
        }
        if (sum % 2 != 0) {
            return false;
        }
        // recursively check each subset
        return couldBePartitioned(nums, 0, sum / 2);
    }

    private boolean couldBePartitioned(int[] nums, int currentIndex, int currentCapacity) {
        // out of bounds
        if (currentIndex >= nums.length) {
            return false;
        }
        if (currentCapacity == 0) {
            return true;
        }
        // we can either:
        // - include the current number (if it fits into capacity)
        // - exclude it
        boolean including = false;
        // including
        if (currentCapacity - nums[currentIndex] >= 0) {
            including = couldBePartitioned(nums, currentIndex + 1, currentCapacity - nums[currentIndex]);
        }
        // excluding
        boolean excluding = couldBePartitioned(nums, currentIndex + 1, currentCapacity);
        return including || excluding;
    }

}
