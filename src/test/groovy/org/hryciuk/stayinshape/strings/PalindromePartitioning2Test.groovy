package org.hryciuk.stayinshape.strings

import spock.lang.Specification

class PalindromePartitioning2Test extends Specification {

    def "should return minimum number of cuts so that string is partitioned into palindromes"(String input, int expectedCuts) {
        given:

        when:

        then:

        where:
        input         | expectedCuts
        "aab"         | 2
        "abbac"       | 1
        "abba"        | 0
        "piotrek"     | 6
        "abrakadabra" | 8


    }
}
