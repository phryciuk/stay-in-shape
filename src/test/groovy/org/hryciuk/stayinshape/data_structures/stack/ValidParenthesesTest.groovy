package org.hryciuk.stayinshape.data_structures.stack

import spock.lang.Specification

class ValidParenthesesTest extends Specification {
    def "should determine whether parentheses are valid"(String input, boolean expected) {
        given:
        ValidParentheses validParentheses = new ValidParentheses()

        when:
        boolean actual = validParentheses.isValid(input)

        then:
        actual == expected

        where:
        input   || expected
        "()"    || true
        "()[]{}" | true
        "(]"    || false
        "([)]"  || false
        "{[]}"  || true
        "(("    || false
    }
}
