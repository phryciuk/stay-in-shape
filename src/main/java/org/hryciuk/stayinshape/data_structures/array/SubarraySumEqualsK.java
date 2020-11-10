package org.hryciuk.stayinshape.data_structures.array;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {

    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int numberOfArrays = 0;
        int[] prefixSum = new int[nums.length];
        prefixSum[0] = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }
        Map<Integer, Integer> sumToOccurrences = new HashMap<>();
        sumToOccurrences.put(0, 1);
        // sum[r] - sum[l - 1] = k
        // sum [l - 1] = l - sum[r]
        for (int i = 0; i < nums.length; ++i) {
            int need = prefixSum[i] - k;
            if (sumToOccurrences.containsKey(need)) {
                numberOfArrays += sumToOccurrences.get(need);
            }
            sumToOccurrences.put(prefixSum[i], sumToOccurrences.getOrDefault(prefixSum[i], 0) + 1);
        }
        return numberOfArrays;
    }
}
