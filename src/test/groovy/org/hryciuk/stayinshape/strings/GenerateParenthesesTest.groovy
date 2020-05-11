package org.hryciuk.stayinshape.strings

import spock.lang.Specification

class GenerateParenthesesTest extends Specification {
    def "should generate valid parentheses pairs"(int input, List<String> expected) {
        given:
        GenerateParentheses generateParentheses = new GenerateParentheses();

        when:
        List<String> actual = generateParentheses.generateParenthesis(input)

        then:
        actual == expected

        where:
        input | expected
        2     | ["(())", "()()"]
        3     | [
                "((()))",
                "(()())",
                "(())()",
                "()(())",
                "()()()"
        ]
    }
}
