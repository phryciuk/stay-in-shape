package org.hryciuk.stayinshape.algorithms.binary_search;

/**
 * https://leetcode.com/problems/binary-search/discuss/423162/Binary-Search-101
 */
public class BinarySearch {

    public int binarySearchHigherMid(int target, int[] array) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int lo = 0;
        int hi = array.length - 1;

        // Loop continues until lo == hi
        while (lo < hi) {
            int middle = lo + (hi - lo + 1) / 2; // right, upper mid
//            int middle = lo + (hi - lo)  / 2; // left, lower mid; WRONG; infinite loop for 2 element range where target >= middle
            if (target < array[middle]) {
                hi = middle - 1;
            } else {
                lo = middle;
            }
        }
        return array[lo] == target ? lo : -1;
    }

    public int binarySearchLowerMid(int target, int[] array) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int lo = 0;
        int hi = array.length - 1;

        while (lo < hi) {
            int middle = lo + (hi - lo) / 2; // left, lower mid
            if (target > array[middle]) {
                lo = middle + 1;
            } else {
                hi = middle;
            }
        }
        return array[lo] == target ? lo : -1;
    }

    public int binarySearchRecursive(int[] arr, int target) {
        int lo = 0;
        int hi = arr.length - 1;
        return binarySearchHelper(arr, target, lo, hi);
    }

    private int binarySearchHelper(int[] arr, int target, int lo, int hi) {
        if (lo < 0 || hi >= arr.length || lo > hi) {
            return -1;
        }
        int mid = lo + (hi - lo) / 2;
        if (target == arr[mid]) {
            return mid;
        } else if (target < arr[mid]) {
            return binarySearchHelper(arr, target, lo, mid - 1);
        } else {
            return binarySearchHelper(arr, target, mid + 1, hi);
        }
    }


}
