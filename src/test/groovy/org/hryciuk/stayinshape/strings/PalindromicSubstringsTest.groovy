package org.hryciuk.stayinshape.strings

import spock.lang.Specification

class PalindromicSubstringsTest extends Specification {

    def "should count palindromic substrings"(String input, int expected) {
        given:
        PalindromicSubstrings palindromicSubstrings = new PalindromicSubstrings()

        when:
        int actual = palindromicSubstrings.countSubstrings(input)

        then:
        actual == expected

        where:
        input     | expected
        "abc"     | 3
        "aaa"     | 6
        "abba"    | 6
        "aabaaca" | 12
    }
}
