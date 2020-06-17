package org.hryciuk.stayinshape.strings

import spock.lang.Specification

class ToLowerCaseTest extends Specification {

    def "should change the string to lowercase"(String input, String expected) {
        given:
        ToLowerCase toLowerCase = new ToLowerCase()

        when:
        String actual = toLowerCase.toLowerCase(input)

        then:
        actual == expected

        where:
        input    | expected
        "SIEMA"  | "siema"
        "siema"  | "siema"
        "pOlSkA" | "polska"
    }
}
