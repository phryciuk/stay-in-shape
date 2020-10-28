package org.hryciuk.stayinshape.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 46. Permutations
 * Medium
 *
 * Given a collection of distinct integers, return all possible permutations.
 *
 * Example:
 *
 * Input: [1,2,3]
 * Output:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 */
public class Permutations {


    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        List<Integer> current = new LinkedList<>();
        permuteHelper(current, nums, result);
        return result;
    }

    private void permuteHelper(List<Integer> current, int[] nums, List<List<Integer>> result) {
        if (current.size() == nums.length) {
            result.add(new LinkedList<>(current));
            return;
        } else {
            for (int i = 0; i < nums.length; ++i) {
                if (current.contains(nums[i])) {
                    continue;
                } else {
                    current.add(nums[i]);
                    permuteHelper(current, nums, result);
                    current.remove(current.size() - 1);
                }
            }
        }
    }
}
