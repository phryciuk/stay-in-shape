package org.hryciuk.stayinshape.sorting;

class QuickSort {
    private int[] array;

    public QuickSort(int[] array) {
        this.array = array;
    }

    void quickSort(int p, int r) {
        if (p < r) {
            int q = partition(p, r);
            quickSort(p, q - 1);
            quickSort(q + 1, r);
        }
    }

    private int partition(int p, int r) {
        int pivot = array[r];
        int i = p - 1;
        for (int j = p; j < r; j++) {
            if (array[j] <= pivot) {
                i++;
                swap(i, j);
            }
        }
        swap(i + 1, r);

        // Return the index of where the pivot ended up.
        return i + 1;
    }

    private void swap(int i, int j) {
        int t = array[i];
        array[i] = array[j];
        array[j] = t;
    }

    public int[] getArray() {
        return array;
    }
}
