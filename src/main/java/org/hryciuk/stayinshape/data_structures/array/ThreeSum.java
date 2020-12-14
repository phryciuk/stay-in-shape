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
        List<List<Integer>> result = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < nums.length; ++i) {
            int current = nums[i];
            List<Integer> subresult = twoSum(current * - 1, nums, i);
            if (!subresult.isEmpty()) {
                Collections.sort(subresult);
                set.add(subresult);
            }
        }
        result.addAll(set);
        return result;
    }

    private List<Integer> twoSum(int target, int[] nums, int indexToOmit) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            if (i == indexToOmit) {
                continue;
            }
            if (map.containsKey(target - nums[i])) {
                result.add(nums[i]);
                result.add(target - nums[i]);
                result.add(-1 * target);
                return result;
            } else {
                map.put(nums[i], i);
            }
        }
        return result;
    }


}
