package org.hryciuk.stayinshape.data_structures.heap;

public class KthSmallestElementInASortedMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        int numberOfElements = matrix.length * matrix.length;
        int[] flattenedArray = new int[numberOfElements];
        for (int i = 0; i < numberOfElements; i++) {
            int row = i / matrix.length;
            int column = i % matrix.length;
            flattenedArray[i] = matrix[row][column];
        }
        buildMinHeap(flattenedArray);
        // to get k smallest element you need to remove k -1 elements from heap
        for (int i = 0; i < k - 1; i++) {
            removeRootNode(flattenedArray, flattenedArray.length - 1 - i);
        }
        return flattenedArray[0];
    }

    private void removeRootNode(int[] heap, int lastIndexOfHeap) {
        swap(heap, 0, lastIndexOfHeap);
        minHeapify(heap, 0, lastIndexOfHeap);
    }

    private void buildMinHeap(int[] array) {
        for (int i = array.length / 2; i >= 0; --i) {
            minHeapify(array, i, array.length);
        }
    }

    private void minHeapify(int[] array, int index, int lastIndexOfHeap) {
        int leftChild = index * 2 + 1;
        int rightChild = index * 2 + 2;
        int smallest = index;
        if (leftChild < lastIndexOfHeap && array[leftChild] < array[smallest]) {
            smallest = leftChild;
        }
        if (rightChild < lastIndexOfHeap && array[rightChild] < array[smallest]) {
            smallest = rightChild;
        }
        if (smallest != index) {
            swap(array, smallest, index);
            minHeapify(array, smallest, lastIndexOfHeap);
        }
    }

    private void swap(int[] array, int toBeSwapped, int toBeSwappedWith) {
        int tmp = array[toBeSwapped];
        array[toBeSwapped] = array[toBeSwappedWith];
        array[toBeSwappedWith] = tmp;
    }


}
