package org.hryciuk.stayinshape.strings

import spock.lang.Specification

class PalindromePartitioningTest extends Specification {

    def "should return all palindromic partitions"(String input, String[][] expectedCuts) {
        given:
        PalindromePartitioning palindromePartitioning = new PalindromePartitioning();

        when:
        String[][] actual = palindromePartitioning.partition(input)

        then:
        Arrays.equals(actual, expectedCuts)

        where:
        input         | expectedCuts
        "aab"         | [["aa", "b"], ["a", "a", "b"]]
    }

}
