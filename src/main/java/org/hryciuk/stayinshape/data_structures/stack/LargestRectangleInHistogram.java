package org.hryciuk.stayinshape.data_structures.stack;

import java.util.LinkedList;
import java.util.Deque;

public class LargestRectangleInHistogram {

    //https://leetcode.com/problems/largest-rectangle-in-histogram/solutions/28900/short-and-clean-o-n-stack-based-java-solution/comments/27732
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new LinkedList<>();
        int maxArea = Integer.MIN_VALUE;
        for (int i = 0; i <= heights.length; ++i) {
            int currentHeight = i == heights.length ? 0 : heights[i];
            while (!stack.isEmpty() && currentHeight < heights[stack.peek()]) {
                int poppedHeight = heights[stack.pop()];
                int prevIndex = stack.isEmpty() ? -1 : stack.peek();
                int area = poppedHeight * (i - prevIndex - 1);
                maxArea = Math.max(area, maxArea);
            }
            stack.push(i);
        }
        return maxArea;
    }

    // more verbose but easier to understand
    public int largestRectangleArea2(int[] heights) {
        Deque<Integer> stack = new LinkedList<>();
        int maxArea = 0;
        for (int i = 0; i < heights.length; ++i) {
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                int poppedHeight = heights[stack.pop()];
                int startingIndex = stack.isEmpty() ? -1 : stack.peek();
                int area = poppedHeight * (i - startingIndex - 1);
                maxArea = Math.max(maxArea, area);
            }
            stack.push(i);
        }

        // we still need to go through the elements that were left in the stack. Now these are also in increasing order
        while (!stack.isEmpty()) {
            int poppedHeight = heights[stack.pop()];
            int startingIndex = stack.isEmpty() ? -1 : stack.peek();
            int area = poppedHeight * (heights.length - startingIndex - 1);
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }
}
