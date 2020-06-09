package org.hryciuk.stayinshape.strings

import spock.lang.Specification

class FizzBuzzTest extends Specification {

    def "should print fizz buzz"(int input, List<String> expected) {
        given:
        FizzBuzz fizzBuzz = new FizzBuzz()

        when:
        List<String> actual = fizzBuzz.fizzBuzz(15)

        then:
        actual == expected

        where:
        input | expected
        15    | ["1", "2", "Fizz", "4", "Buzz", "Fizz", "7", "8", "Fizz", "Buzz", "11", "Fizz", "13", "14", "FizzBuzz"]
    }
}
