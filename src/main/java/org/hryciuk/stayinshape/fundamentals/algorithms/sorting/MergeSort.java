package org.hryciuk.stayinshape.fundamentals.algorithms.sorting;

class MergeSort {
    private int[] array;

    public MergeSort(int[] array) {
        this.array = array;
    }

    void mergeSort(int p, int r) {
        if (p < r) {
            int q = (p + r) / 2; // this is actual floor
            mergeSort(p, q);
            mergeSort(q + 1, r);
            merge(p, q, r);
        }
    }

    // p, q, r - indeksy początku środka i końca
    void merge(int p, int q, int r) {
        int leftSize = q - p + 1;
        int rightSize = r - q;
        int[] leftArray = new int[leftSize + 1];
        int[] rightArray = new int[rightSize + 1];

        for (int i = 0; i < leftSize; ++i) {
            leftArray[i] = array[p + i];
        }
        for (int j = 0; j < rightSize; ++j) {
            rightArray[j] = array[q + j + 1];
        }

        leftArray[leftSize] = Integer.MAX_VALUE;
        rightArray[rightSize] = Integer.MAX_VALUE;

        int i = 0;
        int j = 0;

        // r + 1 bo dla przypadku gdy mergujemy 2 elementy np. p = 0, r = 1 to wtedy musimy obydwa przestawić
        for (int k = p; k < r + 1; ++k) {
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
        }
    }

    public int[] getArray() {
        return array;
    }
}
