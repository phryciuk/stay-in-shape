package org.hryciuk.stayinshape.strings

import spock.lang.Specification

class ValidAnagramTest extends Specification {

    def 'should determine whether anagram is valid'() {
        given:
        ValidAnagram validAnagram = new ValidAnagram()

        when:
        def actual = validAnagram.isAnagram(first, second)

        then:
        actual == expected

        where:
        first         | second       || expected
        "anagram"     | "nagaram"     | true
        "cat"         | "rac"         | false
        "car"         | "rac"         | true
        "jimmorrison" | "mrmojorisin" | true
    }
}
