package org.hryciuk.stayinshape.strings

import spock.lang.Specification

class RansomNoteTest extends Specification {
    def "should define whether the ransom note could be created out of the magazine"(String ransomNote, String magazine, boolean expected) {
        given:
        RansomNote ransomNoteClass = new RansomNote()

        when:
        boolean actual = ransomNoteClass.canConstruct(ransomNote, magazine)

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
