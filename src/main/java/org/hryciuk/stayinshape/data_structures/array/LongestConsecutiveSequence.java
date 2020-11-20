package org.hryciuk.stayinshape.data_structures.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

    // time O(n) | space O(n)
    public int longestConsecutive2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int longest = 1;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; ++i) {
            set.add(nums[i]);
        }

        for (int current : set) {
            if (!set.contains(current - 1)) {
                int next = current + 1;
                while(set.contains(next)) {
                    next = next + 1;
                }
                longest = Math.max(longest, next - current);
            }
        }
        return longest;
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
