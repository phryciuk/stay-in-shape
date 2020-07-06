package org.hryciuk.stayinshape.data_structures.array;

/**
 * 34. Find First and Last Position of Element in Sorted Array
 * Medium
 * <p>
 * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
 * <p>
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * <p>
 * If the target is not found in the array, return [-1, -1].
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 */
public class FindFirstAndLastPositionOfElementInSortedArray {

    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        int first = binarySearchFirst(nums, target);
        int last = binarySearchLast(nums, target);
        int[] result = new int[]{first, last};
        return result;
    }

    private int binarySearchFirst(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] > target) {
                hi = mid - 1;
            } else if (nums[mid] < target) {
                lo = mid + 1;
            } else {
                if (mid - 1 >= 0 && nums[mid - 1] < nums[mid]) {
                    return mid;
                } else {
                    hi = mid - 1;
                }
            }
        }
        if (hi < 0) {
            return nums[hi + 1] == target ? hi + 1 : -1;
        }
        return nums[hi] == target ? hi : -1;
    }

    private int binarySearchLast(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] > target) {
                hi = mid - 1;
            } else if (nums[mid] < target) {
                lo = mid + 1;
            } else {
                if (mid + 1 < nums.length && nums[mid + 1] > nums[mid]) {
                    return mid;
                } else {
                    lo = mid + 1;
                }
            }
        }
        if (lo >= nums.length) {
            return nums[lo - 1] == target ? lo - 1 : -1;
        }
        return nums[lo] == target ? lo : -1;
    }

}
