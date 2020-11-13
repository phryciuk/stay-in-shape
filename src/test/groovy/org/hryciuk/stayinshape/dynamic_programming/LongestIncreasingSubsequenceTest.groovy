package org.hryciuk.stayinshape.dynamic_programming

import spock.lang.Specification

class LongestIncreasingSubsequenceTest extends Specification {

    def "should determine longest increasing subsequence"(int[] nums, int expected) {
        given:
        LongestIncreasingSubsequence longestIncreasingSubsequence = new LongestIncreasingSubsequence()

        when:
        int actual = longestIncreasingSubsequence.lengthOfLIS(nums)

        then:
        actual == expected

        where:
        nums                                || expected
        [4, 10, 4, 3, 8, 9]                 || 3
        [0]                                 || 1
        [3, 2]                              || 1
        [10, 9, 2, 5, 3, 7, 101, 18]        || 4
        [10, 22, 9, 33, 21, 50, 41, 60, 80] || 6
        [50, 3, 10, 7, 40, 80]              || 4
        [3, 10, 2, 1, 20]                   || 3
        [3, 4, -1, 0, 20, 2, 3]             || 4
        [2, 5, 1, 8, 3]                     || 3
    }

}
