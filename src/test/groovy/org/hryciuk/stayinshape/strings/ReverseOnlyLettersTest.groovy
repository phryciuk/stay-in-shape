package org.hryciuk.stayinshape.strings

import spock.lang.Specification

class ReverseOnlyLettersTest extends Specification {

    def "should reverse only letters in string"(String input, String expected) {
        given:
        ReverseOnlyLetters reverseOnlyLetters = new ReverseOnlyLetters()

        when:
        String actual = reverseOnlyLetters.reverseOnlyLetters(input)

        then:
        actual == expected

        where:
        input                  | expected
        "?6C40E"               | "?6E40C"
        "ab-cd"                | "dc-ba"
        "a-bC-dEf-ghIj"        | "j-Ih-gfE-dCba"
        "Test1ng-Leet=code-Q!" | "Qedo1ct-eeLg=ntse-T!"
    }
}
