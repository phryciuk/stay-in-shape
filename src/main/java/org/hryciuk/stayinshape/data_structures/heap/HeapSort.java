package org.hryciuk.stayinshape.data_structures.heap;

public class HeapSort {

   public static void heapSort(int[] array) {
        buildHeap(array);
        for (int lastHeapElementIndex = array.length - 1; lastHeapElementIndex > 0; lastHeapElementIndex--) {
            removeRoot(array, lastHeapElementIndex);
        }
    }

    private static void removeRoot(int[] array, int lastElementIndex) {
        swap(0, lastElementIndex, array);
        heapify(array, 0, lastElementIndex);
    }

    private static void buildHeap(int[] array) {
        for (int i = array.length / 2; i >= 0; i--) {
            heapify(array, i, array.length);
        }
    }

    private static void heapify(int[] array, int index, int heapSize) {
        int leftChild = index * 2 + 1;
        int rightChild = index * 2 + 2;
        int largest = index;
        if (leftChild < heapSize && array[leftChild] > array[largest]) {
            largest = leftChild;
        }
        if (rightChild < heapSize && array[rightChild] > array[largest]) {
            largest = rightChild;
        }
        if (largest != index) {
            swap(index, largest, array);
            heapify(array, largest, heapSize);
        }
    }

    public static void swap(int toSwap, int toSwapWith, int[] array) {
        int tmp = array[toSwap];
        array[toSwap] = array[toSwapWith];
        array[toSwapWith] = tmp;
    }
}
