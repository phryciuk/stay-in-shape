package org.hryciuk.stayinshape.data_structures.array;

/**
 * 665. Non-decreasing Array
 * Easy
 * <p>
 * Given an array nums with n integers, your task is to check if it could become non-decreasing by modifying at most 1 element.
 * <p>
 * We define an array is non-decreasing if nums[i] <= nums[i + 1] holds for every i (0-based) such that (0 <= i <= n - 2).
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [4,2,3]
 * Output: true
 * Explanation: You could modify the first 4 to 1 to get a non-decreasing array.
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [4,2,1]
 * Output: false
 * Explanation: You can't get a non-decreasing array by modify at most one element.
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 10 ^ 4
 * - 10 ^ 5 <= nums[i] <= 10 ^ 5
 */
public class NonDecreasingArray {
    public boolean checkPossibility(int[] nums) {
        if (nums.length < 3) return true;
        int previous = nums[0];
        int numberOfViolations = 0;
        for (int i = 0; i < nums.length; ++i) {
            int current = nums[i];
            if (current < previous) {
                numberOfViolations++;
                if (numberOfViolations == 2) {
                    return false;
                }
                if (i + 1 < nums.length && nums[i + 1] >= current && nums[i - 1] > nums[i + 1] && nums.length == 3){
                    return true;
                } else if (i + 1 < nums.length && nums[i + 1] >= current && nums[i - 1] > nums[i + 1] && numberOfViolations > 1){
                    return false;
                } else if (i - 2 >= 0 && i + 1 < nums.length && nums[i + 1] >= current && nums[i - 1] > nums[i + 1] && current < nums[i - 2]) {
                    return false;
                }
            }
            previous = current;
        }
        return true;
    }
}
