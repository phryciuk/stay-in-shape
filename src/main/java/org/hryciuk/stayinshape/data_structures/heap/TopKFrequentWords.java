package org.hryciuk.stayinshape.data_structures.heap;

import java.util.*;

/**
 * 692. Top K Frequent Words
 * Medium
 * <p>
 * Given a non-empty list of words, return the k most frequent elements.
 * <p>
 * Your answer should be sorted by frequency from highest to lowest.
 * If two words have the same frequency, then the word with the lower alphabetical order comes first.
 * <p>
 * Example 1:
 * <p>
 * Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
 * Output: ["i", "love"]
 * Explanation: "i" and "love" are the two most frequent words.
 * Note that "i" comes before "love" due to a lower alphabetical order.
 * <p>
 * Example 2:
 * <p>
 * Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
 * Output: ["the", "is", "sunny", "day"]
 * Explanation: "the", "is", "sunny" and "day" are the four most frequent words,
 * with the number of occurrence being 4, 3, 2 and 1 respectively.
 * <p>
 * Note:
 * <p>
 * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 * Input words contain only lowercase letters.
 * <p>
 * Follow up:
 * <p>
 * Try to solve it in O(n log k) time and O(n) extra space.
 */
public class TopKFrequentWords {

    public List<String> topKFrequent(String[] words, int k) {

        // prepare the map of occurrences; O(n)
        Map<String, Integer> numberOfOccurrences = new HashMap<>();
        for (int i = 0; i < words.length; ++i) {
            numberOfOccurrences.put(words[i], numberOfOccurrences.getOrDefault(words[i], 0) + 1);
        }

        // create a min heap. if the value is higher then peek then we need to replace the peek with that value; O(n logn)
        PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>(k,
                (a, b) -> a.getValue().equals(b.getValue()) // if values are the same
                        ? b.getKey().compareTo(a.getKey()) // then let's compare keys. Keys that bigger go first.
                        : a.getValue() - b.getValue()); // otherwise we sort with ascending order
        for (Map.Entry<String, Integer> entry : numberOfOccurrences.entrySet()) {
            minHeap.add(entry);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        // create result list; O(n)
        List<String> result = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            Map.Entry<String, Integer> polled = minHeap.poll();
            result.add(polled.getKey());
        }
        Collections.reverse(result); // since this is a min heap we need to reverse the order at the end.
        return result;
    }

}
