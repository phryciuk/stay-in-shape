package org.hryciuk.stayinshape.fundamentals.algorithms.sorting;

public class QuicksortHoare {

    public void sort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    // invoke with (0, size - 1)
    public void quickSort(int[] arr, int lo, int hi) {
        if (lo < hi) {
            int splitIndex = partition2(arr, lo, hi);
            quickSort(arr, lo, splitIndex - 1);
            quickSort(arr, splitIndex + 1, hi);
        }
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

    private int partition2(int[] arr, int low, int high) {
        int pivot = arr[low];
        int i = low;
        int j = high;

        while (i < j) {
            while (arr[i] <= pivot && i <= high - 1) {
                i++;
            }

            while (arr[j] > pivot && j >= low + 1) {
                j--;
            }
            if (i < j) swap(arr, i, j);
        }
        swap(arr, low, j);
        return j;
    }

    private void swap(int[] arr, int i, int j) {
        int toReplace = arr[i];
        arr[i] = arr[j];
        arr[j] = toReplace;
    }
}
