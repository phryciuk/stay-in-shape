package org.hryciuk.stayinshape.strings

import spock.lang.Specification

class LongestRepeatingCharacterReplacementTest extends Specification {
    def "should return the length of longest substring"(String input, int k, int expected) {
        given:
        LongestRepeatingCharacterReplacement longestRepeatingCharacterReplacement = new LongestRepeatingCharacterReplacement()

        when:
        int actual = longestRepeatingCharacterReplacement.characterReplacement(input, k)

        then:
        actual == expected

        where:
        input     | k | expected
        "abab"    | 2 | 4
        "cbda"    | 2 | 3
        "aababba" | 1 | 4
        "ababc"   | 2 | 4
        "cbda"    | 1 | 2
    }
}
