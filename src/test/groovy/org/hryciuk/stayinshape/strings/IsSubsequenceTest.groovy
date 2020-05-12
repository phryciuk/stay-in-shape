package org.hryciuk.stayinshape.strings

import spock.lang.Specification

class IsSubsequenceTest extends Specification {
    def "should tell if is a subsequence"(String s, String t, boolean expected) {
        given:
        IsSubsequence isSubsequence = new IsSubsequence()

        when:
        def actual = isSubsequence.isSubsequence(s, t)

        then:
        actual == expected

        where:
        s     | t        | expected
        "abc" | "ahbgdc" | true
        ""    | "ahbgdc" | true
        "axc" | "ahbgdc" | false
        "ace" | "abcde"  | true
        "aec" | "abcde"  | false


    }
}
