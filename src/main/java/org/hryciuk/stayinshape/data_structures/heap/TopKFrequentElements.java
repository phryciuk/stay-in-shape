package org.hryciuk.stayinshape.data_structures.heap;

import java.util.*;

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

    //Time complexity: O(n)
    //Space complexity: O(n)
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();

        for (int i = 0; i < nums.length; ++i) {
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
        }

        List<List<Integer>> frequencies = new ArrayList<>(nums.length + 1);
        for (int i = 0; i < nums.length + 1; ++i) {
            List<Integer> newList = new ArrayList<>();
            frequencies.add(i, newList);
        }

        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            frequencies.get(entry.getValue()).add(entry.getKey());
        }

        int[] result = new int[k];
        int j = 0;
        for (int i = nums.length; i >= 0; i--) {
            if (!frequencies.get(i).isEmpty()) {
                for (int n : frequencies.get(i)) {
                    result[j++] = n;
                    if (j == k) {
                        return result;
                    }
                }
            }
        }
        return result;
    }

    // Time complexity: O(k logn)
    // Space complexity: O(n)
    public int[] topKFrequent2(int[] nums, int k) {
        Map<Integer, Integer> occurrences = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            occurrences.put(nums[i], occurrences.getOrDefault(nums[i], 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> heap = new PriorityQueue<>(k, (a, b) -> b.getValue() - a.getValue()); // sort descending
        for (Map.Entry<Integer, Integer> entry : occurrences.entrySet()) {
            heap.add(entry);
        }

        int[] result = new int[k];
        int index = 0;
        while (!heap.isEmpty() && index < k) {
            Map.Entry<Integer, Integer> entry = heap.poll();
            result[index++] = entry.getKey();
        }
        return result;
    }

    public int[] topKFrequent3(int[] nums, int k) {
        Map<Integer, Integer> frequencies = new HashMap<>();

        for (int i = 0; i < nums.length; ++i) {
            int current = nums[i];
            frequencies.put(current, frequencies.getOrDefault(current, 0) + 1);
        }

        int[] result = new int[k];
        List<Integer>[] list = new List[nums.length + 1];
        // initialize with empty lists
        for (int i = 0; i < nums.length + 1; ++i) {
            list[i] = new ArrayList<>();
        }

        for (Map.Entry<Integer, Integer> entry : frequencies.entrySet()) {
            list[entry.getValue()].add(entry.getKey());
        }

        int index = 0;
        for (int i = list.length - 1; i >= 0; i--) {
            if (!list[i].isEmpty()) {
                for (int e : list[i]) {
                    result[index++] = e;
                    if (index == k) {
                        return result;
                    }
                }
            }
        }
        return result;
    }
}
