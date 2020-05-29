package org.hryciuk.stayinshape.strings

import spock.lang.Specification

class LongestSubstringWithKDistinctCharactersTest extends Specification {
    def 'should find longest substring with k distinct characters'(String input, int k, int expected) {
        given:
        LongestSubstringWithKDistinctCharacters longestSubstringWithKDistinctCharacters = new LongestSubstringWithKDistinctCharacters()

        when:
        int actual = longestSubstringWithKDistinctCharacters.findLength(input, k)

        then:
        actual == expected

        where:
        input       | k || expected
        "araaci"    | 2 || 4
        "araaci"    | 1 || 2
        "cbbebi"    | 3 || 5
        "ccccccccc" | 1 || 9
    }
}
