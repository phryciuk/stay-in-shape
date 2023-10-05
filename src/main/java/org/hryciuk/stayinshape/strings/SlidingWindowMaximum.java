package org.hryciuk.stayinshape.strings;

import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // monotonic decreasing queue
        Deque<Integer> deque = new LinkedList<>();
        int l = 0;
        int[] result = new int[nums.length - k + 1];
        int index = 0;
        for (int r = 0; r < nums.length; ++r) {
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[r]) {
                deque.pollLast();
            }
            deque.add(r);
            if (l > deque.peekFirst()) {
                deque.pollFirst();
            }
            if (r - l + 1 >= k) {
                result[index++] = nums[deque.peekFirst()];
                l++;
            }
        }
        return result;
    }
}
