package org.hryciuk.stayinshape.sorting;

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
        while (true) {
            do {
                i++;
            } while (array[i] < pivot);
            do {
                j--;
            } while (array[j] > pivot);
            if (i < j) swap(i, j);
            else return j;
        }
    }

    private void swap(int i, int j) {
        int toReplace = array[i];
        array[i] = array[j];
        array[j] = toReplace;
    }


    public int[] getArray() {
        return array;
    }
}
