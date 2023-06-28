package org.hryciuk.stayinshape.fundamentals.algorithms.sorting;

import java.util.ArrayList;
import java.util.List;

class MergeSort {

    void mergeSort(int[] arr, int lo, int hi) {
        if (lo < hi) {
            int mid = lo + (hi - lo) / 2; // this is actual floor
            mergeSort(arr, lo, mid);
            mergeSort(arr, mid + 1, hi);
            merge(arr, lo, mid, hi);
        }
    }

    void merge(int[] arr, int lo, int mid, int hi) {
        List<Integer> tmp = new ArrayList<>();
        int left = lo;
        int right = mid + 1;
        while (left <= mid && right <= hi) {
            if (arr[left] <= arr[right]) {
                tmp.add(arr[left]);
                left++;
            } else {
                tmp.add(arr[right]);
                right++;
            }
        }

        // elements on the right moved; we just copy elements from left
        while (left <= mid) {
            tmp.add(arr[left]);
            left++;
        }
        // elements on the left moved; we just copy elements from right
        while (right <= hi) {
            tmp.add(arr[right]);
            right++;
        }
        // copy tmp array to final array
        for (int i = lo; i <= hi; ++i) {
            arr[i] = tmp.get(i - lo);
        }
    }
}
