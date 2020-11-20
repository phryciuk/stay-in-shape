package org.hryciuk.stayinshape.dynamic_programming;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class LongestIncreasingSubsequence {

    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] longest = new int[nums.length];
        longest[0] = 1;
        Arrays.fill(longest, 1);
        int max = 1;
        for (int i = 0; i < nums.length; ++i) {
            for (int j = 0; j < i; ++j) {
                int current = nums[i];
                if (current > nums[j]) {
                    longest[i] = Math.max(longest[i], longest[j] + 1);
                }
                max = Math.max(max, longest[i]);
            }
        }
        return max;
    }

    // Patience sort:
    // https://www.cs.princeton.edu/courses/archive/spring13/cos423/lectures/LongestIncreasingSubsequence.pdf
    // https://leetcode.com/problems/longest-increasing-subsequence/discuss/74824/JavaPython-Binary-search-O(nlogn)-time-with-explanation
    public int longestIncreasingSubsequence(int[] nums) {
        Deque<Integer>[] piles = new Deque[nums.length];
        for (int i = 0; i < piles.length; ++i) {
            piles[i] = new LinkedList<>();
        }
        int size = 0;
        for (int i = 0; i < nums.length; ++i) {
            int current = nums[i];
            int index = binarySearchForLeftmostPile(piles, current, size);
            piles[index].push(current);
            if (index == size) {
                ++size;
            }
        }
        return size;
    }

    // we look for the leftmost pile on which we could put
    // THIS IS ASCENDING ORDER!
    private int binarySearchForLeftmostPile(Deque<Integer>[] piles, int number, int sizeOfLongestIncreasingSubsequence) {
        int lo = 0;
        int hi = sizeOfLongestIncreasingSubsequence;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (piles[mid].peek() < number) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    public int lengthOfLIS2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] piles = new int[nums.length];
        int size = 0;
        for (int i = 0; i < nums.length; ++i) {
            int current = nums[i];
            int index = binarySearchForMinPile(piles, current, size);
            piles[index] = current;
            if (index == size) {
                size++;
            }
        }
        return size;
    }

    private int binarySearchForMinPile(int[] piles, int target, int size) {
        int lo = 0; int hi = size;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (piles[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
}
