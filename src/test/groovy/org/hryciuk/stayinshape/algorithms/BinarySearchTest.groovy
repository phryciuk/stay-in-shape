package org.hryciuk.stayinshape.algorithms

import org.hryciuk.stayinshape.algorithms.binary_search.BinarySearch
import spock.lang.Specification
import spock.lang.Unroll

class BinarySearchTest extends Specification {

    @Unroll
    def 'should find an element within a log(n) time'(int target, int[] input, int expected) {
        given:
        BinarySearch binarySearch = new BinarySearch();

        when:
        def actual = binarySearch.binarySearch( input, target)

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

    @Unroll
    def 'should find an element within a log(n) time alternatively'(int target, int[] input, int expected) {
        given:
        BinarySearch binarySearch = new BinarySearch();

        when:
        def actual = binarySearch.binarySearchLowerMid(target, input)

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

    @Unroll
    def 'should find an element within a log(n) time recursively'(int target, int[] input, int expected) {
        given:
        BinarySearch binarySearch = new BinarySearch();

        when:
        def actual = binarySearch.binarySearchRecursive(input, target)

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

    @Unroll
    def 'should find an element within a log(n) time on array sorted in descending order'(int target, int[] input, int expected) {
        given:
        BinarySearch binarySearch = new BinarySearch();

        when:
        def actual = binarySearch.binarySearchOnSortedDescending(input, target)

        then:
        actual == expected

        where:
        target | input           | expected
        2      | [5, 4, 3, 2, 1] | 3
        2      | [5, 4, 3, 1, 0] | -1
        6      | [5, 4, 3, 1, 0] | -1
        3      | [5, 4, 3, 1, 0] | 2
        5      | [5, 4, 3, 1, 0] | 0
        3      | [1, 0]          | -1
        1      | [1, 0]          | 0
        0      | [1, 0]          | 1
    }
}
