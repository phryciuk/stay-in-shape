package org.hryciuk.stayinshape.data_structures.array

import spock.lang.Specification
import spock.lang.Unroll

class WordSearch2Test extends Specification {
    @Unroll
    def "should find a word in a grid"(char[][] grid, String[] words, boolean expected) {
        given:
        WordSearch2 wordSearch = new WordSearch2()

        when:
        boolean actual = wordSearch.findWords(grid, words)

        then:
        actual == expected

        where:
        grid                                                                                     | words                         || expected
        [["o", "a", "a", "n"], ["e", "t", "a", "e"], ["i", "h", "k", "r"], ["i", "f", "l", "v"]] | ["oath", "pea", "eat", "rain"] | ["eat", "oath"]
        [["o", "a", "b", "n"], ["o", "t", "a", "e"], ["a", "h", "k", "r"], ["a", "f", "l", "v"]] | ["oa", "oaa"]                  | ["oa", "oaa"]
        [["a", "b"], ["c", "d"]]                                                                 | ["abcb"]                       | []
    }
}
