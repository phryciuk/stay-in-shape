package org.hryciuk.stayinshape.algorithms.binary_search

import spock.lang.Specification
import spock.lang.Unroll

class SearchA2DMatrixTest extends Specification {
    @Unroll
    def "should find a value in a sorted 2d array"(int[][] matrix, int target, boolean expected) {
        given:
        SearchA2DMatrix searchA2DMatrix = new SearchA2DMatrix()

        when:
        boolean actual = searchA2DMatrix.searchMatrix(matrix, target)
        then:
        actual == expected

        where:
        matrix                                             | target || expected
        [[1, 3, 5, 7], [10, 11, 16, 20], [23, 30, 34, 50]] | 3       | true
        [[1, 3, 5, 7], [10, 11, 16, 20], [23, 30, 34, 50]] | 13      | false
        []                                                 | 0       | false
        [[]]                                               | 1       | false
    }
}
