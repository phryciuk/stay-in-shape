package org.hryciuk.stayinshape.dynamic_programming

import spock.lang.Specification

class TargetSumTest extends Specification {

    def "should return in how many ways we can reach target sum"(int[] nums, int s, int expected) {
        given:
        TargetSum targetSum = new TargetSum()

        when:
        int result = targetSum.findTargetSumWays(nums, s)

        then:
        result == expected

        where:
        nums                     | s  | expected
//        [1, 1, 1, 1, 1]          | 3  | 5
//        [1, 1]                   | 2  | 1
//        [1, 2, 4, 6, 8]          | 3  | 2
//        [2, 2, 2, 2, 2, 2, 2, 2] | 4  | 56
//        [1, 2, 4, 6, 7]          | 20 | 1
        [1, 0]                   | 1  | 2


    }
}
