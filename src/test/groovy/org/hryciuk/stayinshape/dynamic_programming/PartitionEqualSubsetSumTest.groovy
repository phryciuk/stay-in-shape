package org.hryciuk.stayinshape.dynamic_programming

import spock.lang.Specification

class PartitionEqualSubsetSumTest extends Specification {

    def "should check if the array could be partitioned with equal weights"(int[] nums, boolean expected) {
        given:
        PartitionEqualSubsetSum partitionEqualSubsetSum = new PartitionEqualSubsetSum()

        when:
        boolean actual = partitionEqualSubsetSum.partitionEqualSubsetSum3(nums)

        then:
        actual == expected

        where:
        nums            | expected
        [1, 1, 3, 4, 7] | true
        [2, 3, 4, 6]    | false
        [1, 2, 3, 4]    | true
        [1, 5, 11, 5]   | true
        [1, 2, 3, 5]    | false
        [1, 2, 5]       | false
        [2, 2, 1, 1]    | true
    }
}
