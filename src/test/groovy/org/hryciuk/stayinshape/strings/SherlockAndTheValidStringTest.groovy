package org.hryciuk.stayinshape.strings

import spock.lang.Specification
import spock.lang.Unroll

class SherlockAndTheValidStringTest extends Specification {

    def "should tell whether the number of occurrences of characters is the same"(String input, boolean expected) {
        given:
        SherlockAndTheValidString sameNumberOfOccurrencesOfCharacters = new SherlockAndTheValidString()

        when:
        boolean actual = sameNumberOfOccurrencesOfCharacters.sameNumberOfOccurrencesOfEveryCharacter(input)

        then:
        actual == expected

        where:
        input     | expected
        "aabb"    | true
        "aabbcc"  | true
        "aabbccd" | false
        "aabbccc" | false
        ""        | true
        null      | true
    }

    @Unroll
    def "should tell whether the number of occurrences of characters is the same or off by 1"(String input, boolean expected) {
        given:
        SherlockAndTheValidString sameNumberOfOccurrencesOfCharacters = new SherlockAndTheValidString()

        when:
        boolean actual = sameNumberOfOccurrencesOfCharacters.sameNumberOfOccurrencesOfEveryCharacterOrOffByOne(input)

        then:
        actual == expected

        where:
        input      | expected
        "aabb"     | true
        "aabbcc"   | true
        "aabbccd"  | true
        "aabbccc"  | true
        ""         | true
        null       | true
        "aaabb"    | true
        "aaabbbcc" | false
        "aaabbbc"  | true
        "aaabccc"  | true
        "ppoov"    | true
        "poov"     | true
        "pooov"    | false
        "aaabbccc" | false
    }
}
