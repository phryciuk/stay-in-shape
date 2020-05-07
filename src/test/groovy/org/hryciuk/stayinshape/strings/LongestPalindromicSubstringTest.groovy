package org.hryciuk.stayinshape.strings

import spock.lang.Specification

class LongestPalindromicSubstringTest extends Specification {
    def "should return longest palindromic substring"(String input, String expectedLongestPalindromicSubstring) {
        given:
        LongestPalindromicSubstring longestPalindromicSubstring = new LongestPalindromicSubstring()

        when:
        def actual = longestPalindromicSubstring.longestPalindrome(input)

        then:
        expectedLongestPalindromicSubstring == actual

        where:
        input | expectedLongestPalindromicSubstring
        "babad" | "bab"
        "babad" | "aba"
        "cbbd"  | "bb"
        "a"     | "a"
        "bb"  | "bb"
    }
}
