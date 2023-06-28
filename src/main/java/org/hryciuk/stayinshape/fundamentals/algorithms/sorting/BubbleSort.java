package org.hryciuk.stayinshape.fundamentals.algorithms.sorting;

public class BubbleSort {
    public void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; ++i) {
            boolean swapped = false;
            for (int j = 1; j < arr.length - i; ++j ) {
                int prev = j - 1;
                if (arr[prev] > arr[j]) {
                    swap(arr, j, prev);
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[j];
        arr[j] = arr[i];
        arr[i] = tmp;
    }

    public void recursiveBubbleSort(int[] arr) {
        recursive(arr, 0, arr.length - 1);
    }

    public void recursive (int[] arr, int i, int endIndex) {
        if (i > endIndex) {
            return;
        }
        int current = i;
        int prev = i - 1;
        for (int j = 0; j <= endIndex; ++j) {
            if (arr[current] < arr[prev]) {
                swap(arr, current, prev);
            }
        }
        recursive(arr, i + 1, endIndex);
    }
}
