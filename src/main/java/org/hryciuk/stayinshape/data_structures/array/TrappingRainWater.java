package org.hryciuk.stayinshape.data_structures.array;

/**
 * https://leetcode.com/problems/trapping-rain-water/
 *
 */
public class TrappingRainWater {
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int[] lmax = new int[height.length];
        int[] rmax = new int[height.length];

        lmax[0] = height[0];
        for (int i = 1; i < height.length; ++i) {
            lmax[i] = Math.max(lmax[i - 1], height[i]);
        }

        rmax[height.length - 1] = height[height.length - 1];
        for (int i = height.length - 2; i >= 0; i--) {
            rmax[i] = Math.max(rmax[i + 1], height[i]);
        }

        int totalAmountOfWater = 0;
        for (int i = 0; i < height.length; ++i) {
            int amount = Math.min(lmax[i], rmax[i]);
            totalAmountOfWater += amount - height[i];
        }
        return totalAmountOfWater;
    }
}
