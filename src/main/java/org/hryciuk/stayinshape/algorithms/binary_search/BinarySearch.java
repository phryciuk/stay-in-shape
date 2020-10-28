package org.hryciuk.stayinshape.algorithms.binary_search;

/**
 * https://leetcode.com/problems/binary-search/discuss/423162/Binary-Search-101
 */
public class BinarySearch {

    public int binarySearchAnIndex(int target, int[] array) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int lo = 0;
        int hi = array.length - 1;

        // Loop continues until lo == hi
        while (lo < hi) {
            int middle = lo + (hi - lo + 1)  / 2; // right, upper mid
//            int middle = lo + (hi - lo)  / 2; // left, lower mid; WRONG; infinite loop for 2 element range where target >= middle
            if (target < array[middle]) {
                hi = middle - 1;
            } else {
                lo = middle;
            }
        }
        return array[lo] == target ? lo : -1;
    }

    public int findAnIndexOfANumberAlternative(int target, int[] array) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int lo = 0;
        int hi = array.length - 1;

        while (lo < hi) {
            int middle = lo + (hi - lo)  / 2; // left, lower mid
            if (target > array[middle]) {
                lo = middle + 1;
            } else {
                hi = middle;
            }
        }
        return array[lo] == target ? lo : -1;
    }

}
