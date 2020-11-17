package org.hryciuk.stayinshape.data_structures.array;

public class TwoSum2 {
    public int[] twoSum(int[] numbers, int target) {
        int lo = 0;
        int hi = numbers.length - 1;
        while (lo < hi) {
            int val = numbers[lo] + numbers[hi];
            if (val == target) {
                return new int[]{lo + 1, hi + 1};
            } else if (val > target) {
                hi--;
            } else {
                lo++;
            }
        }
        return new int[]{-1, -1};
    }
}
