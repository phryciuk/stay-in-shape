package org.hryciuk.stayinshape.data_structures.array;

public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }
        if (nums.length == 2) {
            if (nums[0] == target || nums[1] == target) {
                return target == nums[0] ? 0 : 1;
            } else {
                return -1;
            }
        }
        int lowestElementIndex = binarySearchLowestElement(nums, 0, nums.length - 1);
        if (target == nums[lowestElementIndex]) return lowestElementIndex;
        int lo = 0;
        int hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int realmid = (lowestElementIndex + mid) % nums.length;
            if (nums[realmid] == target) {
                return realmid;
            }
            if (nums[realmid] > target) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return -1;
    }

    int binarySearchLowestElement(int[] nums, int lo, int hi) {
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int left = binarySearchLowestElement(nums, lo, mid - 1);
            int right = binarySearchLowestElement(nums, mid + 1, hi);
            if (nums[mid] < nums[left] && nums[mid] < nums[right]) {
                return mid;
            } else if (nums[left] < nums[right]) {
                return left;
            } else {
                return right;
            }
        }
        return lo;
    }
}
