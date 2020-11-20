package org.hryciuk.stayinshape.strings

import spock.lang.Specification

class LongestSubstringWithoutRepeatingCharactersTest extends Specification {
    def "should return the length of longest substring without repeating characters"(String input, int expected) {
        given:
        LongestSubstringWithoutRepeatingCharacters longestSubstringWithoutRepeatingCharacters = new LongestSubstringWithoutRepeatingCharacters()

        when:
        int actual = longestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring2(input)

        then:
        actual == expected

        where:
        input      | expected
        ""         | 0
        "abcabcbb" | 3
        "bbbbbbb"  | 1
        "pwwkew"   | 3
        "ababab"   | 2
        "dvdf"     | 3
        "abba"     | 2

    }
}
