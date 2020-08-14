package org.hryciuk.stayinshape.data_structures.heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/sort-characters-by-frequency/
 * 451. Sort Characters By Frequency
 * Medium
 *
 * Given a string, sort it in decreasing order based on the frequency of characters.
 *
 * Example 1:
 *
 * Input:
 * "tree"
 *
 * Output:
 * "eert"
 *
 * Explanation:
 * 'e' appears twice while 'r' and 't' both appear once.
 * So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
 *
 * Example 2:
 *
 * Input:
 * "cccaaa"
 *
 * Output:
 * "cccaaa"
 *
 * Explanation:
 * Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
 * Note that "cacaca" is incorrect, as the same characters must be together.
 *
 * Example 3:
 *
 * Input:
 * "Aabb"
 *
 * Output:
 * "bbAa"
 *
 * Explanation:
 * "bbaA" is also a valid answer, but "Aabb" is incorrect.
 * Note that 'A' and 'a' are treated as two different characters.
 */
public class SortCharactersByFrequency {
    public String frequencySort(String s) {
        Map<Character, Integer> occurrencesMap = new HashMap<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; ++i) {
            occurrencesMap.put(chars[i], occurrencesMap.getOrDefault(chars[i], 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> priorityQueue = new PriorityQueue<>((a,b) -> b.getValue() - a.getValue());
        priorityQueue.addAll(occurrencesMap.entrySet());

        StringBuilder sb = new StringBuilder();
        while (!priorityQueue.isEmpty()) {
            Map.Entry<Character, Integer> polled = priorityQueue.poll();
            Integer termination = polled.getValue();
            for (int i = 0; i < termination; i++) {
                sb.append(polled.getKey());
            }
        }
        return sb.toString();
    }
}
