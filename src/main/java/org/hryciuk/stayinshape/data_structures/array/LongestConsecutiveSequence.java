package org.hryciuk.stayinshape.data_structures.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

    // time O(n) | space O(n)
    public int longestConsecutive2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; ++i) {
            set.add(nums[i]);
        }
        int max = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (set.contains(nums[i] - 1)) {
                continue;
            }
            int length = 0;
            while (set.contains(nums[i] + length)) {
                length++;
            }
            max = Math.max(max, length);
        }
        return max;
    }

    // time O(n log(n)) | space O(1)
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int max = 1;
        int longest = 1;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] == nums[i - 1]) {
                continue;
            } else if (nums[i] == nums[i - 1] + 1) {
                longest++;
            } else {
                max = Math.max(max, longest);
                longest = 1;
            }
        }
        max = Math.max(max, longest);
        return max;
    }
}
