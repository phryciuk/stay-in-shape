package org.hryciuk.stayinshape.data_structures.heap;

import java.util.*;

public class KClosestPointsToOrigin {

    public int[][] kClosestQuickSelect(int[][] points, int k) {
        if (points == null || points.length == 0) {
            return points;
        }
        int lo = 0;
        int hi = points.length - 1;
        while (lo < hi) {
            int pivotIndex = partition(points, lo, hi);
            if (pivotIndex == k) {
                break;
            } else if (pivotIndex > k) {
                hi = pivotIndex - 1;
            } else {
                lo = pivotIndex + 1;
            }
        }
        return Arrays.copyOfRange(points, 0, k);
    }

    private int partition(int[][] points, int lo, int hi) {
        double pivotDist = distanceFromOrigin(points[lo]);
        int i = lo - 1;
        int j = hi + 1;
        while (i < j) {
            do {
                i++;
            } while (distanceFromOrigin(points[i]) < pivotDist);
            do {
                j--;
            } while (distanceFromOrigin(points[j]) > pivotDist);
            if (i < j) {
                swap(points, i, j);
            }
        }
        return j;
    }

    private void swap(int[][] arr, int i, int j) {
        int[] tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private int compare(int[] point1, int[] point2) {
        double dist1 = distanceFromOrigin(point1);
        double dist2 = distanceFromOrigin(point2);
        return Double.compare(dist1, dist2);
    }

    public int[][] kClosest(int[][] points, int K) {
        if (points == null || points.length == 0) {
            return points;
        }
        Map<Point, Double> pointToDistance = new HashMap<>();
        for (int[] point : points) {
            pointToDistance.put(new Point(point[0], point[1]), distanceFromOrigin(point));
        }
        PriorityQueue<Map.Entry<Point, Double>> heap = new PriorityQueue<>(K, (entry1, entry2) -> Double.compare(entry1.getValue(), entry2.getValue()));
        heap.addAll(pointToDistance.entrySet());

        List<int[]> result = new LinkedList<>();
        int i = 0;
        while (!heap.isEmpty() && i < K) {
            Point current = heap.poll().getKey();
            result.add(new int[]{current.x, current.y});
            i++;
        }
        return result.toArray(new int[result.size()][2]);
    }

    private double distanceFromOrigin(int[] point) {
        return Math.sqrt(Math.pow(point[0], 2) + Math.pow(point[1], 2));
    }
}

class Point {
    public int x;
    public int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}