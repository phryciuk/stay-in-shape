package org.hryciuk.stayinshape.data_structures.array

import spock.lang.Specification

class MaximumSubarrayTest extends Specification {
    def "should return maximum subarray"(int[] input, int expected) {
        given:
        MaximumSubarray maximumSubarray = new MaximumSubarray()

        when:
        double actual = maximumSubarray.maxSubArray(input)

        then:
        actual == expected

        where:
        input                           || expected
        [-2, 1, -3, 4, -1, 2]           || 5
        [-2, -2, -2]                    || -2
        [-2, 1, -3, 4, -1, 2, 1, -5, 4] || 6
        [-1]                            || -1
        [0]                             || 0
        [1, 1, -2]                      || 2
    }

    def "should return length of maximum subarray"(int[] input, int expected) {
        given:
        MaximumSubarray maximumSubarray = new MaximumSubarray()

        when:
        double actual = maximumSubarray.lengthOfMaxSubarray(input)

        then:
        actual == expected

        where:
        input                           || expected
        [-2, 1, -3, 4, -1, 2]           || 3
        [-2, 1, -3, 4, -1, 2, 1, -5, 4] || 4
        [-1]                            || 1
        [0]                             || 1
        [1, 1, -2]                      || 2
    }
}
