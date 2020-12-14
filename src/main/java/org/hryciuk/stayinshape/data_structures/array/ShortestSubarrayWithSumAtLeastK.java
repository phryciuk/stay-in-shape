package org.hryciuk.stayinshape.data_structures.array;

import java.util.ArrayDeque;
import java.util.Deque;

public class ShortestSubarrayWithSumAtLeastK {
    // https://www.youtube.com/watch?v=aPVelmCFy18&t=444s całkiem rozsądnie koleś gada
    // space : O(n)
    // time : O(n)
    // we maintain a monoqueue = monotonic queue with only increasing values.
        public int shortestSubarray(int[] arr, int k) {
        int len = arr.length;
        int result = len + 1;
        int[] prefixSum = new int[len + 1];
        for (int i = 0; i < len; i++) {
            prefixSum[i + 1] = prefixSum[i] + arr[i];
        }
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < prefixSum.length; i++) {
            while (deque.size() > 0 && prefixSum[i] - prefixSum[deque.getFirst()] >= k)
                result = Math.min(result, i - deque.pollFirst());
            while (deque.size() > 0 && prefixSum[i] <= prefixSum[deque.getLast()])
                deque.pollLast();
            deque.addLast(i);
        }
        return result <= len ? result : -1;
    }

    public int shortestSubarray2(int[] arr, int k) {
        int len = arr.length;
        int[] prefix = new int[len + 1];
        for (int i = 0; i < len; i++) {
            prefix[i + 1] = prefix[i] + arr[i];
        }
        Deque<Integer> deque = new ArrayDeque<>();
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < prefix.length; ++i) {
            while (!deque.isEmpty() && prefix[i] - prefix[deque.getFirst()] >= k) {
                result = Math.min(result, i - deque.pollFirst());
            }
            while (!deque.isEmpty() && prefix[i] <= prefix[deque.getLast()]) {
                deque.pollLast();
            }
            deque.add(i);
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }
}
