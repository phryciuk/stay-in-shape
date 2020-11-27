package org.hryciuk.stayinshape.data_structures.heap;

/**
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
 * <p>
 * Example 1:
 * <p>
 * Input: [3,2,1,5,6,4] and k = 2
 * Output: 5
 * <p>
 * Example 2:
 * <p>
 * Input: [3,2,3,1,2,4,5,5,6] and k = 4
 * Output: 4
 * <p>
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ array's length.
 */
public class KthLargestElementInAnArray {

    public int findKthLargest(int[] arr, int k) {
        buildMinHeap(arr);
        int size = arr.length;
        for (int i = 0; i < arr.length - k; ++i) {
            removeRoot(arr, size--);
        }
        return arr[0];
    }

    private void removeRoot(int[] arr, int size) {
        swap(arr, 0, size - 1);
        minHeapify(arr, 0, size - 1);
    }

    private void buildMinHeap(int[] arr) {
        for (int i = arr.length / 2; i >= 0; i--) {
            minHeapify(arr, i, arr.length);
        }
    }

    private void minHeapify(int[] arr, int i, int size) {
        int smallestIndex = i;
        int leftIndex = i * 2 + 1;
        int rightIndex = i * 2 + 2;

        if (leftIndex < size && arr[leftIndex] < arr[smallestIndex]) {
            smallestIndex = leftIndex;
        }
        if (rightIndex < size && arr[rightIndex] < arr[smallestIndex]) {
            smallestIndex = rightIndex;
        }
        if (smallestIndex != i) {
            swap(arr, i, smallestIndex);
            minHeapify(arr, smallestIndex, size);
        }
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
