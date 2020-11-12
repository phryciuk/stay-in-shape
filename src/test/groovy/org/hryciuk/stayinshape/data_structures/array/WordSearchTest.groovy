package org.hryciuk.stayinshape.data_structures.array

import spock.lang.Specification
import spock.lang.Unroll

class WordSearchTest extends Specification {
    @Unroll
    def "should find a word in a grid"(char[][] grid, String word, boolean expected) {
        given:
        WordSearch wordSearch = new WordSearch()

        when:
        boolean actual = wordSearch.exist(grid, word)

        then:
        actual == expected

        where:
        grid                                                               | word         || expected
        [["A", "B", "C", "E"], ["S", "F", "C", "S"], ["A", "D", "E", "E"]] | "ABCCED"      | true
        [["A", "B", "C", "E"], ["S", "F", "C", "S"], ["A", "D", "E", "E"]] | "SEE"        || true
        [["A", "B", "C", "E"], ["S", "F", "C", "S"], ["A", "D", "E", "E"]] | "ABCB"       || false
        [["A", "B", "C", "E"], ["S", "F", "C", "S"], ["A", "D", "E", "E"]] | ""           || false
        [["A", "B", "C", "E"], ["S", "F", "E", "S"], ["A", "D", "E", "E"]] | "ABCESEEEFS" || true
    }
}
