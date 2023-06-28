package org.hryciuk.stayinshape.dynamic_programming.partition_equal_subset_sum;

public class PartitionEqualSubsetSumMemoization {

    // Time complexity: O(n)
    // Space complexity: O(n * sum/2) (memoization array)
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
        // introducing memoization array for storing already computed results
        // we add 1 to the half to keep things 1 index based
        Boolean[][] memo = new Boolean[nums.length][(sum / 2) + 1];
        // recursively check each subset
        return couldBePartitioned(nums, 0, sum / 2, memo);
    }

    private boolean couldBePartitioned(int[] nums, int currentIndex, int currentCapacity, Boolean[][] memo) {
        // out of bounds
        if (currentIndex >= nums.length) {
            return false;
        }
        // end condition; we can partition the array so that sums are same
        if (currentCapacity == 0) {
            return true;
        }
        if (memo[currentIndex][currentCapacity] != null) {
            return memo[currentIndex][currentCapacity];
        }
        // we can either:
        // - include the current number (if it fits into capacity)
        // - exclude it
        boolean including = false;
        // including
        if (currentCapacity - nums[currentIndex] >= 0) {
            including = couldBePartitioned(nums, currentIndex + 1, currentCapacity - nums[currentIndex], memo);
        }
        // excluding
        boolean excluding = couldBePartitioned(nums, currentIndex + 1, currentCapacity, memo);
        memo[currentIndex][currentCapacity] = including || excluding;
        return memo[currentIndex][currentCapacity];
    }

}
