package org.hryciuk.stayinshape.fundamentals.algorithms.sorting;

public class QuicksortHoare {
    private int[] array;

    public QuicksortHoare(int[] array) {
        this.array = array;
    }

    public void quickSort(int low, int high) {
        if (low < high) {
            int index = partition(low, high);
            quickSort(low, index);
            quickSort(index + 1, high);
        }
    }

    int partition(int low, int high) {
        int pivot = array[low];
        int i = low - 1;
        int j = high + 1;
        while (i < j) {
            do {
                i++;
            } while (array[i] < pivot);
            do {
                j--;
            } while (array[j] > pivot);
            if (i < j) {
                swap(i, j);
            }
        }
        return j;
    }

    private void swap(int i, int j) {
        int toReplace = array[i];
        array[i] = array[j];
        array[j] = toReplace;
    }

    private void swap(int[] arr, int i, int j) {
        int toReplace = arr[i];
        arr[i] = arr[j];
        arr[j] = toReplace;
    }

    public int[] getArray() {
        return array;
    }

    // invoke with (0, size - 1)
    public void quickSort(int[] arr, int lo, int hi) {
        if (lo < hi) {
            int splitIndex = partition(arr, lo, hi);
            quickSort(lo, splitIndex);
            quickSort(splitIndex + 1, hi);
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
}
