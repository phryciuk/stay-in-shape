package org.hryciuk.stayinshape.strings

import spock.lang.Specification
import spock.lang.Unroll

class RansomNoteTest extends Specification {
    @Unroll
    def "should define whether the ransom note could be created out of the magazine"(String ransomNote, String magazine, boolean expected) {
        given:
        RansomNote ransomNoteClass = new RansomNote()

        when:
        boolean actual = ransomNoteClass.canConstruct2(ransomNote, magazine)

        then:
        expected == actual

        where:
        ransomNote | magazine | expected
        "a"        | "b"      | false
        "aa"       | "ab"     | false
        "aa"       | "aab"    | true
        ""         | ""       | true

    }
}
