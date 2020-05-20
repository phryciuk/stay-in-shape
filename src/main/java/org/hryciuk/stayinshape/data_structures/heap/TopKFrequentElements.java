package org.hryciuk.stayinshape.data_structures.heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 347. Top K Frequent Elements
 * Medium
 *
 * Given a non-empty array of integers, return the k most frequent elements.
 *
 * Example 1:
 *
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 *
 * Example 2:
 *
 * Input: nums = [1], k = 1
 * Output: [1]
 *
 * Note:
 *
 *     You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 *     Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 *     It's guaranteed that the answer is unique, in other words the set of the top k frequent elements is unique.
 *     You can return the answer in any order.
 */
public class TopKFrequentElements {

    public int[] topKFrequent(int[] nums, int k) {
        if (k < 1) {
            throw new IllegalArgumentException();
        }
        Map<Integer, Integer> mapOfOccurrences = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            mapOfOccurrences.put(nums[i], mapOfOccurrences.getOrDefault(nums[i], 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(k, (a, b) -> a.getValue() - b.getValue());

        for (Map.Entry<Integer, Integer> entry : mapOfOccurrences.entrySet()) {
            if (minHeap.size() < k) {
                minHeap.add(entry);
            } else {
                if (entry.getValue() > minHeap.peek().getValue()) {
                    minHeap.poll();
                    minHeap.add(entry);
                }
            }
        }

        int[] result = new int[k];
        int i = 0;
        while (!minHeap.isEmpty()) {
            result[i] = minHeap.poll().getKey();
            ++i;
        }
        return result;
    }
}
