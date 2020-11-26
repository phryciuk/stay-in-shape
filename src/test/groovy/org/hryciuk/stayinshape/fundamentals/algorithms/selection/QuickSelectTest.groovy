package org.hryciuk.stayinshape.fundamentals.algorithms.selection

import spock.lang.Specification

class QuickSelectTest extends Specification {

    def 'should return k smallest element'(int[] input, int k, int expected) {
        given:
        QuickSelect quickSelect = new QuickSelect()

        when:
        int actual = quickSelect.getKthSmallestElement(input, k)

        then:
        actual == expected

        where:
        input               | k || expected
        [1, -2, 5, 8, 7, 6] | 3 || 5
    }

    def 'should return kth largest element'(int[] input, int k, int expected) {
        given:
        QuickSelect quickSelect = new QuickSelect()

        when:
        int actual = quickSelect.getKthLargestElement(input, k)

        then:
        actual == expected

        where:
        input               | k || expected
        [1, -2, 5, 8, 7, 6] | 1 || 8
    }

    def 'should return k largest elements'(int[] input, int k, int[] expected) {
        given:
        QuickSelect quickSelect = new QuickSelect()

        when:
        int[] actual = quickSelect.getKLargestElements(input, k)

        then:
        actual == expected

        where:
        input               | k || expected
        [1, -2, 5, 8, 7, 6] | 1 || [8]
        [1, -2, 5, 8, 7, 6] | 3 || [6, 7, 8]

    }

    def 'should return k smallest elements'(int[] input, int k, int[] expected) {
        given:
        QuickSelect quickSelect = new QuickSelect()

        when:
        int[] actual = quickSelect.getKSmallestElements(input, k)

        then:
        Arrays.asList(actual).containsAll(Arrays.asList(expected))

        where:
        input                                         | k || expected
        [1, -2, 5, 8, 7, 6]                           | 1 || [-2]
        [1, -2, 5, 8, 7, 6]                           | 3 || [-2, 1, 5]
        [1, -2, 5, 8, 7, 6]                           | 5 || [-2, 1, 5, 6, 7]
        [1, 1, 2, 3]                                  | 2 || [1, 1]
        [91, 103, 110, 111, 116, 118, 31, 46, 67, 87] | 5 || [31, 46, 67, 87, 91]
    }
}
