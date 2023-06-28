package org.hryciuk.stayinshape.fundamentals.algorithms.sorting;

public class SelectionSort {

    public void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; ++i) {
            int min = i;
            for (int j = i; j < arr.length; ++j) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            // swap
            int tmp = arr[i];
            arr[i] = arr[min];
            arr[min] = tmp;
        }
    }
}
