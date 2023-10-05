package org.hryciuk.stayinshape.data_structures.stack

import spock.lang.Specification

class LargestRectangleInHistogramTest extends Specification {
    def "should point largest rectangle in histogram"(int[] input, int expected) {
        given:
        LargestRectangleInHistogram largetRectangleInHistogram = new LargestRectangleInHistogram()

        when:
        int actual = largetRectangleInHistogram.largestRectangleArea(input)

        then:
        actual == expected

        where:
        input              || expected
        [2, 1, 5, 6, 2, 3] || 10
        [2, 4]             || 4

    }
}
