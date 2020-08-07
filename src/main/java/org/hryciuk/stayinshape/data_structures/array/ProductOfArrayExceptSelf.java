package org.hryciuk.stayinshape.data_structures.array;

public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        if (nums.length == 1) {
            return nums;
        }

        int n = nums.length;

        // what is the product of everything except self?
        // it is a product of everything to the right of the product and everything to the left of the product
        // first we calculate the product of the elements on the left of the element
        int[] output = new int[n];
        output[0] = 1;
        for (int i = 1; i < n; ++i) {
            output[i] = output[i - 1] * nums[i -1];
        }

        int initial = 1;

        for (int i = n - 1; i >= 0; i--) {
            int tmp = output[i];
            output[i] *= initial;
            initial *= nums[i];
        }

        return output;
    }
}
