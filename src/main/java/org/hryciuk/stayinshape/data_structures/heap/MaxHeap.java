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

    void insertToMaxHeap(int value) {
        ensureCapacity();
        int index = size;
        int temp = value;
        heap[index] = value;
        while (index > 0 && heap[index / 2] < temp) {
            heap[index] = heap[index / 2];
            index = index / 2;
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
}
