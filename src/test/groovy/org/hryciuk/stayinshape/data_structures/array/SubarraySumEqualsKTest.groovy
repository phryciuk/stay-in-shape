package org.hryciuk.stayinshape.data_structures.array

import spock.lang.Specification
import spock.lang.Unroll

class SubarraySumEqualsKTest extends Specification {
    @Unroll
    def "should say whether subarray sum equals to K"(int[] nums, int k, int expected) {
        given:
        SubarraySumEqualsK subarraySumEqualsK = new SubarraySumEqualsK()

        when:
        int actual = subarraySumEqualsK.subarraySum(nums, k)

        then:
        actual == expected

        where:
        nums                      | k | expected
        [1, 1, 1]                 | 2 | 2
        [1, 2, 3]                 | 3 | 2
        [1]                       | 0 | 0
        [-1, -1, 1]               | 0 | 1
        [3, 4, 7, 2, -3, 1, 4, 2] | 7 | 4
    }
}
