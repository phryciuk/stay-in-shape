package org.hryciuk.stayinshape.data_structures.array;

import java.util.*;

/**
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0?
 * Find all unique triplets in the array which gives the sum of zero.
 * <p>
 * Note: The solution set must not contain duplicate triplets.
 * <p>
 * For example, given array S = [-1, 0, 1, 2, -1, -4],
 * <p>
 * A solution set is:
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                twoSum(nums, i, result);
            }
        }
        return result;
    }

    private void twoSum(int[] nums, int i, List<List<Integer>> result) {
        int lo = i + 1;
        int hi = nums.length - 1;
        int current = nums[i];
        int needed = 0 - current; // a + b + c = 0 ==> -c = a + b
        while (lo < hi) {
            if (nums[lo] + nums[hi] == needed) {
                List<Integer> newOne = new ArrayList<>();
                newOne.add(nums[lo]);
                newOne.add(nums[hi]);
                newOne.add(current);
                result.add(newOne);
                lo++;
                hi--;
                while (lo < hi && nums[lo] == nums[lo - 1]) {
                    lo++;
                }
            } else if (nums[lo] + nums[hi] < needed) {
                lo++;
            } else {
                hi--;
            }
        }
    }


}
