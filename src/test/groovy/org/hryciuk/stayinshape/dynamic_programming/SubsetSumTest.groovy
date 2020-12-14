package org.hryciuk.stayinshape.dynamic_programming

import spock.lang.Specification

class SubsetSumTest extends Specification {
    def "should determine if there exists a subset whose sum is equal to a given number S "(int[] nums, int s, boolean expected) {
        given:
        SubsetSum subsetSum = new SubsetSum()

        when:
        boolean actual = subsetSum.subsetEqualToSum(nums, s)

        then:
        actual == expected

        where:
        nums                           | s  | expected
        [1, 2, 3, 7]                   | 6  | true
        [1, 3, 4, 8]                   | 6  | false
        [1, 2, 7, 1, 5]                | 10 | true
        [1, 2, 7]                      | 11 | false
        [15, 22, 14, 26, 32, 9, 16, 8] | 53 | true

    }
}
