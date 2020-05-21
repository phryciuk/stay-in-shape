package org.hryciuk.stayinshape.data_structures.array;

import java.util.ArrayList;
import java.util.List;

public class IntersectionOfTwoArrays {

    public int[] intersection(int[] nums1, int[] nums2) {
        quicksort(nums1, 0, nums1.length - 1);
        quicksort(nums2, 0, nums2.length - 1);

        int i = 0;
        int j = 0;
        int lastAddedElementIndex = -1;
        List<Integer> result = new ArrayList<>();

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
                continue;
            }
            if (nums2[j] < nums1[i]) {
                j++;
                continue;
            }
            if (nums1[i] == nums2[j] && (lastAddedElementIndex == -1 || nums1[i] != nums1[lastAddedElementIndex])) {
                result.add(nums1[i]);
                lastAddedElementIndex = i;
            }
            ++i;
            ++j;
        }
        int[] resultArray = new int[result.size()];
        for (int l = 0; l < result.size(); ++l) {
            resultArray[l] = result.get(l);
        }
        return resultArray;
    }

    private void quicksort(int[] array, int low, int high) {
        if (low < high) {
            int q = partition(array, low, high);
            quicksort(array, low, q - 1);
            quicksort(array, q + 1, high);
        }
    }

    private int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = low - 1; // just before greater elements

        for (int j = low; j < high; ++j) {
            if (array[j] <= pivot) {
                i++;
                swap(i, j, array);
            }
        }
        swap(i + 1, high, array);
        return i + 1;
    }

    private void swap(int i, int j, int[] array) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

}
