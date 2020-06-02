package org.hryciuk.stayinshape.data_structures.array

import spock.lang.Specification

class MaxConsecutiveOnes3Test extends Specification {

    def "should determine the maximum length of consecutive ones"(int[] input, int k, int expected) {
        given:
        MaxConsecutiveOnes3 maxConsecutiveOnes3 = new MaxConsecutiveOnes3()

        when:
        int actual = maxConsecutiveOnes3.longestOnes(input, k)

        then:
        actual == expected

        where:
        input                                                     | k | expected
        [0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1]                         | 2 | 6
        [0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1] | 3 | 10
        [0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1]       | 1 | 7
        [0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1]                         | 5 | 11
    }
}
