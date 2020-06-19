package org.hryciuk.stayinshape.algorithms

import spock.lang.Specification

class BinarySearchTest extends Specification {

    def 'should find an element within a log(n) time'(int target, int[] input, int expected) {
        given:
        BinarySearch binarySearch = new BinarySearch();

        when:
        def actual = binarySearch.binarySearchAnIndex(target, input)

        then:
        actual == expected

        where:
        target | input           | expected
        2      | [1, 2, 3, 4, 5] | 1
        2      | [0, 1, 3, 4, 5] | -1
        6      | [0, 1, 3, 4, 5] | -1
        3      | [0, 1, 3, 4, 5] | 2
        5      | [0, 1, 3, 4, 5] | 4
        3      | [0, 1]          | -1
    }

    def 'should find an element within a log(n) time alternatively'(int target, int[] input, int expected) {
        given:
        BinarySearch binarySearch = new BinarySearch();

        when:
        def actual = binarySearch.findAnIndexOfANumberAlternative(target, input)

        then:
        actual == expected

        where:
        target | input           | expected
        2      | [1, 2, 3, 4, 5] | 1
        2      | [0, 1, 3, 4, 5] | -1
        6      | [0, 1, 3, 4, 5] | -1
        3      | [0, 1, 3, 4, 5] | 2
        5      | [0, 1, 3, 4, 5] | 4
        3      | [0, 1]          | -1
    }
}
