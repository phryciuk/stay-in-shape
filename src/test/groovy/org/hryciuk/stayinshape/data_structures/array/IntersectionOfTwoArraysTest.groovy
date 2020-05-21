package org.hryciuk.stayinshape.data_structures.array

import spock.lang.Specification

class IntersectionOfTwoArraysTest extends Specification {

    def 'should return intersection of 2 arrays'(int[] input, int[] input2, int[] expected) {
        given:
        IntersectionOfTwoArrays intersection = new IntersectionOfTwoArrays();

        when:
        def actual = intersection.intersection(input, input2)

        then:
        Arrays.asList(actual).containsAll(Arrays.asList(expected))

        where:
        input     | input2          || expected
        [2, 2]    | [1, 2, 2, 1]    || [2]
        [4, 9, 5] | [9, 4, 9, 8, 4] || [9, 4]
    }
}
