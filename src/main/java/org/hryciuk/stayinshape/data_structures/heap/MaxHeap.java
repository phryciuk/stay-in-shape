package org.hryciuk.stayinshape.data_structures.heap;

import java.util.Arrays;

public class MaxHeap {

    private int capacity;
    private int size;
    private int[] heap;

    public MaxHeap(int capacity, int size, int[] heap) {
        this.capacity = capacity;
        this.size = size;
        this.heap = heap;
    }

    private void ensureCapacity() {
        if (size == capacity) {
            heap = Arrays.copyOf(heap, size * 2);
            capacity = capacity * 2;
        }
    }

    // O(log(n))
    void insertToMaxHeap(int value) {
        ensureCapacity();
        int index = size;
        heap[index] = value;
        int parentIndex = (index - 1) / 2;
        while (index > 0 && value > heap[parentIndex]) {
            heap[index] = heap[parentIndex];
            index = parentIndex;
            parentIndex = (index - 1) / 2;
        }
        heap[index] = value;
        size++;
    }

    public int[] getHeap() {
        int[] result = new int[size];
        for (int i = 0; i < size; ++i) {
            result[i] = heap[i];
        }
        return result;
    }

    public void removeFromHeap() {
        swap(0, size - 1, heap);
        maxHeapify(this.heap, 0);
        size--;
    }

    // O(n)
    static int[] buildMaxHeap(int[] array) {
        for (int i = array.length / 2; i >= 0; i--) {
            maxHeapify(array, i);
        }
        return array;
    }

    // O(n)
    static void maxHeapify(int[] array, int i) {
        int leftChildIndex = i * 2 + 1;
        int rightChildIndex = i * 2 + 2;
        int largest = i;
        if (leftChildIndex < array.length && array[leftChildIndex] > array[largest]) {
            largest = leftChildIndex;
        }
        if (rightChildIndex < array.length && array[rightChildIndex] > array[largest]) {
            largest = rightChildIndex;
        }
        if (largest != i) {
            swap(i, largest, array);
            maxHeapify(array, largest);
        }
    }

    // O(1)
    static void swap(int current, int other, int[] array) {
        int toSwapWith = array[other];
        array[other] = array[current];
        array[current] = toSwapWith;
    }

}
