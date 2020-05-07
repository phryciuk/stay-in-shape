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
        LinkedList<Integer> ok = new LinkedList<>();
        ok.poll();
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i) {
            List<Integer> tempResult = new ArrayList<>();
            int[] twoIndices = twoSum(nums[i] * -1, nums, i);
            if (twoIndices != null) {
                tempResult.add(nums[twoIndices[0]]);
                tempResult.add(nums[twoIndices[1]]);
                tempResult.add(nums[i]);
                int index = i;
                if (!result.isEmpty()) {
                    if (result.stream().anyMatch(list -> (list.contains(nums[twoIndices[0]]) && list.contains(nums[twoIndices[1]]) && list.contains(nums[index])))) {
                        continue;
                    }
                }
                result.add(tempResult);
            }
        }
        return result;
    }

    private int[] twoSum(int target, int[] nums, int indexToOmit) {
        Map<Integer, Integer> map = new HashMap<>(); // number, index
        for (int i = 0; i < nums.length; ++i) {
            if (indexToOmit == i) {
                continue;
            }
            if (map.get(nums[i]) == null) {
                map.put(target - nums[i], i);
            } else {
                int[] result = new int[2];
                result[0] = map.get(nums[i]);
                result[1] = i;
                return result;
            }
        }
        return null;
    }


}
