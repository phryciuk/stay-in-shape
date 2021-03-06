package org.hryciuk.stayinshape.data_structures.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


/**
 * 287. Find the Duplicate Number
 * Medium
 * <p>
 * Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,3,4,2,2]
 * Output: 2
 * <p>
 * Example 2:
 * <p>
 * Input: [3,1,3,4,2]
 * Output: 3
 * <p>
 * Note:
 * <p>
 * You must not modify the array (assume the array is read only).
 * You must use only constant, O(1) extra space.
 * Your runtime complexity should be less than O(n2).
 * There is only one duplicate number in the array, but it could be repeated more than once.
 */
public class FindTheDuplicateNumber {

    // Time O(n) Space O(1)
    public int findDuplicatesFloyd(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];
        // this is important to start from the same point otherwise finding cycle starting point may become impossible
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        // at that point cycle is detected. Now we need to find the start of the cycle
        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

    // Time O(n), Space: O(n)
    public int findDuplicateSet(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; ++i) {
            if (set.contains(nums[i])) {
                return nums[i];
            } else {
                set.add(nums[i]);
            }
        }
        return -1;
    }

    // Time: O(nlogn) Space: O(1)
    public int findDuplicateSorting(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return nums[i];
            }
        }
        return -1;
    }
}
