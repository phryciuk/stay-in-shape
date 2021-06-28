package org.hryciuk.stayinshape.strings

import spock.lang.Specification

class PalindromePartitioning2Test extends Specification {

    def "should return minimum number of cuts so that string is partitioned into palindromes"(String input, int expectedCuts) {
        given:
        PalindromePartitioning2 palindromePartitioning2 = new PalindromePartitioning2()

        when:
        def actual = palindromePartitioning2.minCuts(input)

        then:
        expectedCuts == actual

        where:
        input         | expectedCuts
        "aab"         | 1
        "abbac"       | 1
        "banana"      | 1
        "efe"         | 0
        "abba"        | 0
        "piotrek"     | 6
        "abrakadabra" | 8
    }
}
