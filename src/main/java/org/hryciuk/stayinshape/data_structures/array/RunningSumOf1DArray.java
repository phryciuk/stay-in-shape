package org.hryciuk.stayinshape.data_structures.array;

public class RunningSumOf1DArray {
    public int[] runningSum(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; ++i) {
            int tmp = nums[i];
            nums[i] += sum;
            sum += tmp;
        }
        return nums;
    }
}
