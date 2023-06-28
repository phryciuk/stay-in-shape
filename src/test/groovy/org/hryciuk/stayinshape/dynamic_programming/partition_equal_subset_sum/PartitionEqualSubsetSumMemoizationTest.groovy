package org.hryciuk.stayinshape.dynamic_programming.partition_equal_subset_sum


import spock.lang.Specification

class PartitionEqualSubsetSumMemoizationTest extends Specification {

    def "should check if the array could be partitioned with equal weights"(int[] nums, boolean expected) {
        given:
        PartitionEqualSubsetSumMemoization partitionEqualSubsetSum = new PartitionEqualSubsetSumMemoization()

        when:
        boolean actual = partitionEqualSubsetSum.canPartition(nums)

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
