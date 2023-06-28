package org.hryciuk.stayinshape.data_structures.array;

public class SearchInRotatedSortedArray {


    public int searchOne(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            // that means that the order to the left is good
            if (nums[mid] >= nums[lo]) {
                if (target > nums[mid] || target < nums[lo]) {
                    lo = mid + 1;
                } else {
                    hi = mid;
                }
            } else {
                if (target > nums[mid] && target < nums[lo]) {
                    lo = mid + 1;
                } else {
                    hi = mid;
                }
            }
        }
        return nums[lo] == target ? lo : -1;
    }

    public int searchInaczej(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        // we use <= because of single element arrays
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            // if the target is found return index
            if (nums[mid] == target) {
                return mid;
            }
            // we are in left side
            if (nums[lo] <= nums[mid]) {
                // target not in left side
                if (target > nums[mid] || target < nums[lo]) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            // right side
            } else {
                // target not in right side
                if (target < nums[mid] || target > nums[hi]) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            }
        }
        return -1;
    }

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int minIndex = findMinIndex(nums);
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int realmid = (mid + minIndex) % nums.length;
            if (nums[realmid] < target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        lo = (lo + minIndex) % nums.length;
        return nums[lo] == target ? lo : -1;
    }

    private int findMinIndex(int[] nums) {
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
    public int search2(int[] nums, int target) {
        int pivot = binarySearchForPivot2(nums);
        int targetIndex = binarySearch2(nums, target, pivot);
        return targetIndex;
    }

    private int binarySearchForPivot2(int[] nums) {
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

    private int binarySearch2(int[] nums, int target, int pivot) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int realMid = (mid + pivot) % nums.length;
            if (nums[realMid] < target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        lo = (lo + pivot) % nums.length;
        return nums[lo] == target ? lo : -1;
    }
}
