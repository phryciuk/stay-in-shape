package org.hryciuk.stayinshape.data_structures.array

import spock.lang.Specification
import spock.lang.Unroll

class BiggestIntegerInMatrixTest extends Specification {

    @Unroll
    def 'should find the biggest integer in the matrix'(int[][] input, int expected) {
        given:
        BiggestIntegerInMatrix biggestIntegerInMatrix = new BiggestIntegerInMatrix()

        when:
        int number = biggestIntegerInMatrix.solution(input)

        then:
        number == expected

        where:
        input                                               | expected
        [[9, 1, 1, 0, 7], [1, 0, 2, 1, 0], [1, 9, 1, 1, 0]] | 9121
        [[9, 9, 9, 9, 9], [9, 9, 9, 9, 9], [9, 9, 9, 9, 9]] | 9999
        [[9, 4, 1, 0, 7], [4, 1, 5, 1, 4], [0, 2, 3, 1, 9]] | 9470
        [[0, 4, 1, 5, 7], [4, 1, 5, 1, 4], [0, 2, 3, 1, 9]] | 9475
    }
}
