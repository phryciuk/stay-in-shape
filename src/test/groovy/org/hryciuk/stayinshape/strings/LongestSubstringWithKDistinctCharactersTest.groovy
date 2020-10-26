package org.hryciuk.stayinshape.strings

import spock.lang.Specification
import spock.lang.Unroll

class LongestSubstringWithKDistinctCharactersTest extends Specification {
    @Unroll
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
        "araaci"    | 4 || 6
        "cbbebi"    | 3 || 5
        "ccccccccc" | 1 || 9
    }
}
