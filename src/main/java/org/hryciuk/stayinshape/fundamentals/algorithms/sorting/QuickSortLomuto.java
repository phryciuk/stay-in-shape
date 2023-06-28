package org.hryciuk.stayinshape.fundamentals.algorithms.sorting;

class QuickSortLomuto {
    private int[] array;

    public QuickSortLomuto(int[] array) {
        this.array = array;
    }

    public void quickSort(int low, int high) {
        if (low < high) {
            int index = partition(low, high);
            quickSort(low, index - 1);
            quickSort(index + 1, high);
        }
    }

    // Lomuto partition scheme
    int partition(int low, int high) {
        int pivot = array[high];
        int i = low - 1;

        for (int j = low; j < high; ++j) {
            if (array[j] <= pivot) {
                ++i;
                swap(i, j);
            }
        }
        i++;
        swap(i, high);
        return i;
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
