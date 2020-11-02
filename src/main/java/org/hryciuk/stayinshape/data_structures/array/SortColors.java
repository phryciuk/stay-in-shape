package org.hryciuk.stayinshape.data_structures.array;

public class SortColors {
    public int[] sortColors(int[] arr) {
        if (arr == null || arr.length == 0) {
            return arr;
        }
        int zeroIndex = 0;
        int twoIndex = arr.length - 1;

        int index = 0;
        while (index <= twoIndex) {
            if (arr[index] == 0) {
                swap(arr, index, zeroIndex);
                index++;
                zeroIndex++;
            } else if (arr[index] == 1) {
                index++;
            } else {
                swap(arr, index, twoIndex);
                twoIndex--;
            }
        }
        return arr;
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
