package org.hryciuk.stayinshape.algorithms.quickselect;

import java.util.Arrays;

public class KClosestPointsToOriginQuickselect {
    public int[][] kClosest(int[][] points, int k) {
        return quickselect(points, 0, points.length - 1, k);
    }

    public int[][] quickselect(int[][] points, int lo, int hi, int k) {
        while (lo < hi) {
            int pivot = partition(points, lo, hi);
            if (pivot < k) {
                lo = pivot + 1;
            } else {
                hi = pivot;
            }
        }
        return Arrays.copyOfRange(points, 0, k);
    }

    public int partition(int[][] points, int lo, int hi) {
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

    private void swap(int[][] points, int i, int j) {
        int[] tmp = points[i];
        points[i] = points[j];
        points[j] = tmp;
    }
}
