package org.hryciuk.stayinshape.data_structures.array;

public class SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        } else if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }
        else if (nums.length == 2) {
            if (nums[0] != target && nums[1] != target) {
                return -1;
            }
            return nums[0] == target ? 0 : 1;
        }
        int minIndex = binarySearchForMinElement(nums);
        return binarySearch(nums, target, minIndex);
    }

    private int binarySearchForMinElement(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] > nums[hi]) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    private int binarySearch(int[] nums, int target, int minIndex) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo + 1) / 2;
            int realMid = (mid + minIndex) % nums.length;
            if (nums[realMid] > target) {
                hi = mid - 1;
            } else {
                lo = mid;
            }
        }
        lo = (lo + minIndex) % nums.length;
        return nums[lo] == target ? lo : -1;
    }
}
