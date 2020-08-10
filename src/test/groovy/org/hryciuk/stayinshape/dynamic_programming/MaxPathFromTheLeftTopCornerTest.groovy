package org.hryciuk.stayinshape.dynamic_programming

import spock.lang.Specification

class MaxPathFromTheLeftTopCornerTest extends Specification {

    def 'should return max path from the left top corner'(int[][] arr, String expected) {
        given:
        MaxPathFromTheLeftTopCorner maxPathFromTheLeftTopCorner = new MaxPathFromTheLeftTopCorner()

        when:
        String actual = maxPathFromTheLeftTopCorner.maxPath(arr)

        then:
        actual == expected

        where:
        arr                                          | expected
        [[9, 9, 7], [9, 7, 2], [6, 9, 5], [9, 1, 2]] | "997952"
        [[1, 5, 2], [7, 4, 3]]                       | "1743"
        [[9, 1, 1], [7, 1, 5], [9, 5, 2]]            | "97952"
        [[9, 8, 7], [8, 1, 5], [7, 5, 2]]            | "98752"
        [[9, 5], [5, 2]]                             | "952"
        [[9], [5]]                                   | "95"
    }
}
