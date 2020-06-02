package org.hryciuk.stayinshape.strings

import spock.lang.Specification

class PermutationInStringTest extends Specification {
    def 'should check if a string contains a permutation of second string'(String s1, String s2, boolean expected) {
        given:
        PermutationInString permutation = new PermutationInString()

        when:
        boolean actual = permutation.checkInclusion(s1, s2)

        then:
        actual == expected

        where:
        s1    | s2          | expected
        "ab"  | "eidbaooo"  | true
        "ab"  | "eidboaoo"  | false
        "ab"  | "eadboabo"  | true
        "ab"  | "ebadboabo" | true
        "ab"  | "ebcadaobo" | false
        "adc" | "dcda"      | true
    }
}
