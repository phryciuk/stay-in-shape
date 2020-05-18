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

    public void removeFromHeap() {
        ensureCapacity();
        int rootValue = heap[0];
        int lastElement = heap[size - 1];
        heap[size - 1] = rootValue;
        heap[0] = lastElement;
        int currentRootIndex = 0;
        int leftChildIndex = 1;
        int rightChildIndex = 2;
        while ((leftChildIndex <= size - 1 && rightChildIndex <=size - 1) && (lastElement <= heap[leftChildIndex] || lastElement <= heap[rightChildIndex])) {
            if (heap[leftChildIndex] > heap[rightChildIndex]) {
                int leftChildValue = heap[leftChildIndex];
                heap[leftChildIndex] = heap[currentRootIndex];
                heap[currentRootIndex] = leftChildValue;
                currentRootIndex = leftChildIndex;
            } else {
                int rightChildValue = heap[rightChildIndex];
                heap[rightChildIndex] = heap[currentRootIndex];
                heap[currentRootIndex] = rightChildValue;
                currentRootIndex = rightChildIndex;
            }
            leftChildIndex = currentRootIndex * 2 + 1;
            rightChildIndex = currentRootIndex * 2 + 2;
        }
        size--;
    }
}
