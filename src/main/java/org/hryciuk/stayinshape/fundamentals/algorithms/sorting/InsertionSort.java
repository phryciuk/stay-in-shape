package org.hryciuk.stayinshape.fundamentals.algorithms.sorting;

class InsertionSort {
    private int[] array;

    public InsertionSort(int[] array) {
        this.array = array;
    }

    public int[] getArray() {
        return array;
    }

    public void insertionSort() {
        for (int i = 1; i < array.length; ++i) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                int tmp = array[j + 1];
                array[j + 1] = array[j];
                array[j] = tmp;
                j--;
            }
            array[j + 1] = key;
        }
    }
}
