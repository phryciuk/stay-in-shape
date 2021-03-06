package org.hryciuk.stayinshape.data_structures.hashmap;

import java.util.HashMap;
import java.util.Map;

public class NRepeatedElementInSize2NArray {


    public int repeatedNTimesImproved(int[] A) {
        int[] occurrences = new int[10000];
        for (int i = 0; i < A.length; ++i) {
            if (occurrences[A[i]]++ == 1) {
                return A[i];
            }
        }
        return -1;
    }

    public int repeatedNTimes(int[] A) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < A.length; ++i) {
            map.put(A[i], map.getOrDefault(A[i], 0) + 1);
        }

        int largest = A[0];
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > map.get(largest)) {
                largest = entry.getKey();
            }
        }
        return largest;
    }

}
