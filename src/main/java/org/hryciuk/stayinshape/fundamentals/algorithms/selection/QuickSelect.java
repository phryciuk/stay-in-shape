package org.hryciuk.stayinshape.fundamentals.algorithms.selection;

import java.util.Arrays;

public class QuickSelect {

    public int getKthSmallestElement(int[] arr, int k) {
        return quickSelect(arr, 0, arr.length - 1, k - 1);
    }

    public int getKthLargestElement(int[] arr, int k) {
        return quickSelect(arr, 0, arr.length - 1, arr.length - k);
    }

    public int[] getKLargestElements(int[] arr, int k) {
        return quickSelectRangeLargest(arr, 0, arr.length - 1, arr.length - k);
    }

    public int[] getKSmallestElements(int[] arr, int k) {
        return quickSelectRange(arr, 0, arr.length - 1, k);
    }

    private int[] quickSelectRange(int[] arr, int low, int high, int k) {
        int lo = low;
        int hi = high;
        while (lo < hi) {
            int pivotIndex = partition(arr, lo, hi);
            if (pivotIndex == k) {
                break;
            } else if (pivotIndex > k) {
                hi = pivotIndex - 1;
            } else {
                lo = pivotIndex + 1;
            }
        }
        return Arrays.copyOfRange(arr, 0, k);
    }

    private int[] quickSelectRangeLargest(int[] arr, int low, int high, int k) {
        int lo = low;
        int hi = high;
        while (lo < hi) {
            int pivotIndex = partition(arr, lo, hi);
            if (pivotIndex == k) {
                break;
            } else if (pivotIndex > k) {
                hi = pivotIndex - 1;
            } else {
                lo = pivotIndex + 1;
            }
        }
        return Arrays.copyOfRange(arr, k, arr.length);
    }

    private int quickSelect(int[] arr, int low, int high, int k) {
        int lo = low;
        int hi = high;
        while (lo < hi) {
            int pivotIndex = partition(arr, lo, hi);
            if (pivotIndex == k) {
                return arr[k];
            } else if (pivotIndex > k) {
                hi = pivotIndex - 1;
            } else {
                lo = pivotIndex + 1;
            }
        }
        return arr[lo];
    }

    private int partition(int[] arr, int lo, int hi) {
        int pivot = arr[lo];
        int i = lo - 1;
        int j = hi + 1;
        while (i < j) {
            do {
                i++;
            } while (arr[i] < pivot);
            do {
                j--;
            } while (arr[j] > pivot);
            if (i < j) {
                swap(arr, i, j);
            }
        }
        return j;
    }


    private void swap(int[] arr, int i, int j) {
        int toReplace = arr[i];
        arr[i] = arr[j];
        arr[j] = toReplace;
    }
}
