package org.hryciuk.stayinshape.dynamic_programming;

public class ContainerWithMostWater {


    public int maxArea(int[] height) {
        if (height.length == 0 || height.length == 1) {
            return 0;
        }
        int l = 0;
        int r = height.length - 1;
        int max = 0;
        while (l < r) {
            int area = (r - l) * Math.min(height[l], height[r]);
            max = Math.max(max, area);
            if (height[r] > height[l]) {
                l++;
            } else if (height[r] < height[l]) {
                r--;
            } else {
                l++;
            }
        }
        return max;
    }

    public int maxAreaQuadratic(int[] height) {
        if (height == null || height.length == 0 || height.length == 1) {
            return 0;
        }
        int[] result = new int[height.length];
        int max = 0;
        for (int i = 1; i < height.length; ++i) {
            for (int j = 0; j < i; ++j) {
                result[i] = Math.max(result[i], area(height, i, j));
                max = Math.max(max, result[i]);
            }
        }
        return max;
    }

    private int area(int[] height, int i, int j) {
        int dist = i - j;
        int firstHeight = height[i];
        int secondHeight = height[j];
        return dist * Math.min(firstHeight, secondHeight);
    }
}
