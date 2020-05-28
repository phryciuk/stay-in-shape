package org.hryciuk.stayinshape.data_structures.array


import spock.lang.Specification

class MaximumAverageSubarrayITest extends Specification {
    def "should return maximum average subarray"(int[] input, int k, double expected) {
        given:
        MaximumAverageSubarrayI maximumAverageSubarrayI = new MaximumAverageSubarrayI()

        when:
        double actual = maximumAverageSubarrayI.findMaxAverage(input, k)

        then:
        actual == expected

        where:
        input                  | k || expected
        [1, 2, 3, 4]           | 2 || 3.5
        [1, 12, -5, -6, 50, 3] | 4  | 12.75
        [-1]                   | 1  | -1

    }
}
