package org.hryciuk.stayinshape.data_structures.array;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * <p>
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * <p>
 * Example:
 * <p>
 * Given nums = [2, 7, 11, 15], target = 9,
 * <p>
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            if (map.get(nums[i]) == null) {
                map.put(target - nums[i], i);
            } else {
                int[] result = new int[2];
                result[0] = map.get(nums[i]);
                result[1] = i;
                return result;
            }
        }
        throw new IllegalStateException("No indices that sum up to a target");
    }

}
