package org.hryciuk.stayinshape.data_structures.array

import spock.lang.Specification

class MaximumSubarrayOfSizeKTest extends Specification {

    def "should return maximum average subarray"(int[] input, int k, int expected) {
        given:
        MaximumSubarrayOfSizeK maximumSubSubarrayOfSizeK = new MaximumSubarrayOfSizeK()

        when:
        double actual = maximumSubSubarrayOfSizeK.findMaxSumSubarray(input, k)

        then:
        actual == expected

        where:
        input              | k || expected
        [2, 1, 5, 1, 3, 2] | 3 || 9
        [2, 3, 4, 1, 5]    | 2 || 7

    }
}
