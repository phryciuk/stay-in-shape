package org.hryciuk.stayinshape.dynamic_programming;

import java.util.Arrays;

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
}
