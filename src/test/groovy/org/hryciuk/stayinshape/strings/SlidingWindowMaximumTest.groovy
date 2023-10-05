package org.hryciuk.stayinshape.strings

import spock.lang.Specification

class SlidingWindowMaximumTest extends Specification {
    def "should return sliding window maximum"(int[] nums, int k, int[] expected) {

        given:
        SlidingWindowMaximum slidingWindowMaximum = new SlidingWindowMaximum()

        when:
        int[] actual = slidingWindowMaximum.maxSlidingWindow(nums, k)

        then:
        actual == expected;

        where:
        nums                       | k | expected
        [1, 3, -1, -3, 5, 3, 6, 7] | 3 | [3, 3, 5, 5, 6, 7]
        [1]                        | 1 | [1]
        [1, -1]                    | 1 | [1, -1]
        [9, 11]                    | 2 | [11]
        [7, 2, 4]                  | 2 | [7, 4]
        [1, 3, 1, 2, 0, 5]         | 3 | [3, 3, 2, 5]
    }
}
