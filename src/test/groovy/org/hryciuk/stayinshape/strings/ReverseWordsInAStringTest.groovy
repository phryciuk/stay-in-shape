package org.hryciuk.stayinshape.strings

import spock.lang.Specification

class ReverseWordsInAStringTest extends Specification {
    def "should reverse words in string"(String input, String expected) {
        given:
        ReverseWordsInAString reverseWordsInAString = new ReverseWordsInAString()

        when:
        String actual = reverseWordsInAString.reverseWords(input)

        then:
        actual == expected

        where:
        input                    | expected
        "the sky is blue"        | "blue is sky the"
        "ab-cd"                  | "ab-cd"
        ""                       | ""
        "piotr"                  | "piotr"
        "piotr hryciuk"          | "hryciuk piotr"
        "janusz kowalski 123654" | "123654 kowalski janusz"
    }
}
