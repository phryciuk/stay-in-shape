package org.hryciuk.stayinshape.data_structures.array

import spock.lang.Specification

class SortColorsTest extends Specification {
    def "should sort colors in place"(int[] input, int[] expected) {
        given:
        SortColors sortColors = new SortColors()

        when:
        int[] actual = sortColors.sortColors(input)

        then:
        actual == expected

        where:
        input              || expected
        [2, 0, 2, 1, 1, 0] || [0, 0, 1, 1, 2, 2]
        [2, 0, 1]          || [0, 1, 2]
        [1, 2, 0]          || [0, 1, 2]
        [0]                || [0]
        [1]                || [1]
    }
}
