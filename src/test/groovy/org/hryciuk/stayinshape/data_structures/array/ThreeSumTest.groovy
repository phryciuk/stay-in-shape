package org.hryciuk.stayinshape.data_structures.array


import spock.lang.Specification

class ThreeSumTest extends Specification {

    def "should return 3sum"(int[] input, int[][] expected3sum) {
        given:
        ThreeSum threeSum = new ThreeSum()

        when:
        def actual = threeSum.threeSum(input)

        then:
        expected3sum.length == actual.size()

        where:
        input                                             | expected3sum
        [-1, 0, 1, 2, -1, -4]                             | [[-1, 0, 1], [-1, -1, 2]]
        [-4, -2, -2, -2, 0, 1, 2, 2, 2, 3, 3, 4, 4, 6, 6] | [[-4, -2, 6], [-4, 0, 4], [-4, 1, 3], [-4, 2, 2], [-2, -2, 4], [-2, 0, 2]]
    }
}
