package org.hryciuk.stayinshape.fundamentals.algorithms.sorting;

public class QuicksortHoare {

    public void sort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    // invoke with (0, size - 1)
    public void quickSort(int[] arr, int lo, int hi) {
        if (lo < hi) {
            int splitIndex = partition(arr, lo, hi);
            quickSort(arr, lo, splitIndex);
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

    private void swap(int[] arr, int i, int j) {
        int toReplace = arr[i];
        arr[i] = arr[j];
        arr[j] = toReplace;
    }
}
