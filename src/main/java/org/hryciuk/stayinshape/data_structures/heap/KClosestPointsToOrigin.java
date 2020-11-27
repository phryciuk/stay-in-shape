package org.hryciuk.stayinshape.data_structures.heap;

import java.util.*;

public class KClosestPointsToOrigin {
    public int[][] kClosest(int[][] points, int k) {
        int lo = 0;
        int hi = points.length - 1;
        while (lo < hi) {
            int pivotPoint = partition(points, lo, hi);
            if (pivotPoint < k) {
                lo = pivotPoint + 1;
            } else {
                hi = pivotPoint;
            }
        }
        List<int[]> result = new ArrayList<>();
        for (int i = 0; i < k; ++i) {
            result.add(points[i]);
        }
        return result.toArray(new int[result.size()][2]);
    }

    private int partition(int[][] points, int lo, int hi) {
        int[] pivot = points[lo];
        int i = lo - 1;
        int j = hi + 1;
        while (i < j) {
            do {
                i++;
            } while (dist(points[i]) < dist(pivot));
            do {
                j--;
            } while (dist(points[j]) > dist(pivot));
            if (i < j) {
                swap(points, i, j);
            }
        }
        return j;
    }

    private double dist(int[] point) {
        return Math.sqrt(Math.pow(point[0], 2) + Math.pow(point[1], 2));
    }

    private void swap(int[][] arr, int i, int j) {
        int[] tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    // own heap
    public int[][] kClosestOwnHeap(int[][] points, int k) {
        buildMaxHeap(points);
        int size = points.length;
        for (int i = 0 ; i < points.length - k; ++i) {
            removeRoot(points, size--);
        }
        return Arrays.copyOfRange(points, 0, k);
    }

    private void removeRoot(int[][] points, int size) {
        swap(points, 0, size - 1);
        maxHeapify(points, 0, size - 1);
    }

    private void buildMaxHeap(int[][] points) {
        for (int i = points.length / 2; i >= 0; i--) {
            maxHeapify(points, i, points.length);
        }
    }

    private void maxHeapify(int[][] points, int i, int size) {
        int largestIndex = i;
        int leftIndex = i * 2 + 1;
        int rightIndex = i * 2 + 2;

        if (leftIndex < size && dist(points[leftIndex]) > dist(points[largestIndex])) {
            largestIndex = leftIndex;
        }
        if (rightIndex < size && dist(points[rightIndex]) > dist(points[largestIndex])) {
            largestIndex = rightIndex;
        }
        if (largestIndex != i) {
            swap(points, i, largestIndex);
            maxHeapify(points, largestIndex, size);
        }
    }

}
