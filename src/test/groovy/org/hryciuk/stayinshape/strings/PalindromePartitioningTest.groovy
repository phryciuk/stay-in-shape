package org.hryciuk.stayinshape.strings

import spock.lang.Specification

class PalindromePartitioningTest extends Specification {
    def "should return all palindromic partitions"(String input, String[][] expectedCuts) {
        given:

        when:

        then:

        where:
        input         | expectedCuts
        "aab"         | [["aa", "b"], ["a", "a", "b"]]

    }
}
