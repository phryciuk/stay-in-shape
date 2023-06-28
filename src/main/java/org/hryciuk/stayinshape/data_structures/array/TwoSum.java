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

    // We keep a hashmap that stores the values and indices
    // We iterate over values
    // We look if number (target - current) is already present in the map
    //      - if it is that means that we have already both numbers
    //      - if it is not, then we just add the current value and index to the map and continue
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> valToIndex = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            if (valToIndex.containsKey(target - nums[i])) {
                int[] result = new int[2];
                result[0] = valToIndex.get(target - nums[i]);
                result[1] = i;
                return result;
            } else {
                valToIndex.put(nums[i], i);
            }
        }
        return new int[]{-1, -1};
    }

}
