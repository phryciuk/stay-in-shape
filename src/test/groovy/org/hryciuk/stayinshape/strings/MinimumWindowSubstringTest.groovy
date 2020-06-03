package org.hryciuk.stayinshape.strings

import spock.lang.Specification

class MinimumWindowSubstringTest extends Specification {
    def "should return minimum window substring"(String input, String pattern, String expected) {

        given:
        MinimumWindowSubstring minimumWindowSubstring = new MinimumWindowSubstring()

        when:
        String actual = minimumWindowSubstring.minWindow(input, pattern)

        then:
        actual == expected;

        where:
        input           | pattern | expected
        "AABDEC"        | "ABC"   | "ABDEC"
        "ADOBECODEBANC" | "ABC"   | "BANC"
        "SIEMA"         | "ABC"   | ""
        "A"             | "A"     | "A"
        "a"             | "a"     | "a"
    }
}
