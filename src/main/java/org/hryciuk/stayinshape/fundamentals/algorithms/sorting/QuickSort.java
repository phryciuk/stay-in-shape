package org.hryciuk.stayinshape.fundamentals.algorithms.sorting;

public class QuickSort {
    public void sort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    // invoke with (0, size - 1)
    public void quickSort(int[] arr, int lo, int hi) {
        if (lo < hi) {
            int partitionIndex = partition(arr, lo, hi);
            quickSort(arr, lo, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, hi);
        }
    }

    // after partition is executed pivot is in the right place of the sorted order
    // not like in Hoare partition
    private int partition(int[] arr, int lo, int hi) {
        int pivot = arr[lo];
        int i = lo;
        int j = hi;

        while (i < j) {
            while(arr[i] <= pivot && i <= hi - 1) {
                i++;
            }
            while(arr[j] > pivot && j >= lo + 1) {
                j--;
            }
            if (i < j) {
                swap(arr, i, j);
            }
        }
        swap(arr, lo, j);
        return j;
    }

    private void swap(int[] arr ,int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
