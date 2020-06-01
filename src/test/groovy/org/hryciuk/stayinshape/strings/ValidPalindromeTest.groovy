package org.hryciuk.stayinshape.strings

import spock.lang.Specification

class ValidPalindromeTest extends Specification {

    def "should determine whether the string is a palindrome"(String input, boolean expected) {

        given:
        ValidPalindrome validPalindrome = new ValidPalindrome()

        when:
        boolean actual = validPalindrome.isPalindrome(input)

        then:
        actual == expected

        where:
        input                               | expected
        "A man, a plan, a canal: Panama"    | true
        "A man,    a plan, a canal: Panama" | true
        "kaj,a,k."                          | true
        "ab@a"                              | true

    }
}
