package org.hryciuk.stayinshape.data_structures.array

import spock.lang.Specification

class ShortestSubarrayWithSumAtLeastKTest extends Specification {

    def " should return shortest subarray with sum at least k"(int[] arr, int k, int expected) {
        given:
        ShortestSubarrayWithSumAtLeastK shortestSubarrayWithSumAtLeastK = new ShortestSubarrayWithSumAtLeastK()

        when:
        int actual = shortestSubarrayWithSumAtLeastK.shortestSubarray2(arr, k)

        then:
        actual == expected

        where:
        arr                    | k  || expected
        [1]                    | 1  || 1
        [1, 2]                 | 4  || -1
        [2, -1, 2]             | 3   | 3
        [2, -1, 2, 1]          | 3   | 2
        [2, 1, -2, 3, 1]       | 4   | 2
        [84, 47, 79, 119, 214] | 220 | 2
        [70, -50, 50, 50, 50]  | 100 | 2

    }
}
