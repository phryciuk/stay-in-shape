package org.hryciuk.stayinshape.data_structures.array

import spock.lang.Specification
import spock.lang.Unroll

class MinimumSizeSubarraySumTest extends Specification {
    @Unroll
    def "should return minimum size subarray sum"(int[] input, int s, int expected) {
        given:
        MinimumSizeSubarraySum minimumSizeSubarraySum = new MinimumSizeSubarraySum()

        when:
        int actual = minimumSizeSubarraySum.minSubArrayLen(s, input)

        then:
        actual == expected

        where:
        input              | s || expected
        [2, 3, 1, 2, 4, 3] | 7 || 2
        [7]                | 7 || 1
        [7]                | 8 || 0
        [3, 4, 1, 1, 6]    | 8 || 3
        [2, 1, 5, 2, 8]    | 7 || 1
        [2, 1, 5, 2, 3, 2] | 7 || 2
    }
}
