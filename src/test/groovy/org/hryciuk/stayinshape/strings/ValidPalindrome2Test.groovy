package org.hryciuk.stayinshape.strings

import spock.lang.Specification

class ValidPalindrome2Test extends Specification {
    def "should determine whether the string is a palindrome"(String input, boolean expected) {

        given:
        ValidPalindrome2 validPalindrome = new ValidPalindrome2()

        when:
        boolean actual = validPalindrome.validPalindrome(input)

        then:
        actual == expected

        where:
        input    | expected
        "aba"    | true
        "abca"   | true
        "abcba"  | true
        "abbbba" | true
        "bbbba"  | true
        "abbbb"  | true
        "tebbem" | false
        "atbbga" | false

    }
}
