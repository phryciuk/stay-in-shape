package org.hryciuk.stayinshape.data_structures.array

import spock.lang.Specification
import spock.lang.Unroll

class ValidSudokuTest extends Specification {
    @Unroll
    def "should check if sudoku is valid"(char[][] board, boolean expected) {
        given:
        ValidSudoku validSudoku = new ValidSudoku()

        when:
        boolean actual = validSudoku.isValidSudoku3(board)

        then:
        actual == expected

        where:
        board                                              || expected
        [["5", "3", ".", ".", "7", ".", ".", ".", "."]
         , ["6", ".", ".", "1", "9", "5", ".", ".", "."]
         , [".", "9", "8", ".", ".", ".", ".", "6", "."]
         , ["8", ".", ".", ".", "6", ".", ".", ".", "3"]
         , ["4", ".", ".", "8", ".", "3", ".", ".", "1"]
         , ["7", ".", ".", ".", "2", ".", ".", ".", "6"]
         , [".", "6", ".", ".", ".", ".", "2", "8", "."]
         , [".", ".", ".", "4", "1", "9", ".", ".", "5"]
         , [".", ".", ".", ".", "8", ".", ".", "7", "9"]] || true
        [["8", "3", ".", ".", "7", ".", ".", ".", "."]
         , ["6", ".", ".", "1", "9", "5", ".", ".", "."]
         , [".", "9", "8", ".", ".", ".", ".", "6", "."]
         , ["8", ".", ".", ".", "6", ".", ".", ".", "3"]
         , ["4", ".", ".", "8", ".", "3", ".", ".", "1"]
         , ["7", ".", ".", ".", "2", ".", ".", ".", "6"]
         , [".", "6", ".", ".", ".", ".", "2", "8", "."]
         , [".", ".", ".", "4", "1", "9", ".", ".", "5"]
         , [".", ".", ".", ".", "8", ".", ".", "7", "9"]] || false
    }
}
