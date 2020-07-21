package org.hryciuk.stayinshape.data_structures.array

import spock.lang.Specification

class FloodFillTest extends Specification {

    def 'should flood fill the arrray'(int[][] image, int sr, int sc, int newColor, int[][] expected) {
        given:
        FloodFill floodFill = new FloodFill()

        when:
        int[][] actual = floodFill.floodFill(image, sr, sc, newColor);

        then:
        Arrays.deepEquals(actual, expected)

        where:
        image                             | sr | sc | newColor | expected
        [[1, 1, 1], [1, 1, 0], [1, 0, 1]] | 1  | 1  | 2        | [[2, 2, 2], [2, 2, 0], [2, 0, 1]]
        [[0, 0, 1], [0, 1, 1]]            | 1  | 1  | 1        | [[0, 0, 1], [0, 1, 1]]
        [[0, 0, 0], [1, 0, 0]]            | 1  | 0  | 2        | [[0, 0, 0], [2, 0, 0]]
    }
}
