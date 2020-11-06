package org.hryciuk.stayinshape.bit_manipulation;

public class SingleNumber {
    // Time: O(n)
    // Space: O(1)
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; ++i) {
            result ^= nums[i];
        }
        return result;
    }
}
