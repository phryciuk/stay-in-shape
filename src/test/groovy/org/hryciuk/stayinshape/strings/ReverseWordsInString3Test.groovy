package org.hryciuk.stayinshape.strings

import spock.lang.Specification

class ReverseWordsInString3Test extends Specification {

    def 'should reverse words in string'(String input, String output) {
        given:
        ReverseWordsInString3 reverseWordsInString3 = new ReverseWordsInString3()

        when:
        String actual = reverseWordsInString3.reverseWordsziom(input)

        then:
        actual == output

        where:
        input                         | output
        "Let's take LeetCode contest" | "s'teL ekat edoCteeL tsetnoc"
        "Piotrek"                     | "kertoiP"
        "dupa blada ziomek"           | "apud adalb kemoiz"

    }
}
