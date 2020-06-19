package org.hryciuk.stayinshape.data_structures.array

import spock.lang.Specification

class PeakIndexInMountainArrayTest extends Specification {

    def "should return a peak index in mountain array"(int[] input, int expected) {
        given:
        PeakIndexInMountainArray peakIndexInMountainArray = new PeakIndexInMountainArray()

        when:
        int actual = peakIndexInMountainArray.peakIndexInMountainArray(input)

        then:
        actual == expected

        where:
        input                       | expected
        [0, 1, 0]                   | 1
        [0, 2, 1, 0]                | 1
        [3, 2, 1, 0]                | 0
        [0, 1, 2, 3]                | 3
        [1, 0]                      | 0
        [0, 1]                      | 1
    }
}
