package org.hryciuk.stayinshape.strings


import spock.lang.Specification

class FindAllAnagramsInStringTest extends Specification {

    def "should return indices where the anagrams of passed string passed"(String input, String pattern, List<Integer> expected) {

        given:
        FindAllAnagramsInString findAllAnagramsInString = new FindAllAnagramsInString()

        when:
        List<Integer> actual = findAllAnagramsInString.findAnagrams(input, pattern)

        then:
        actual == expected;

        where:
        input     | pattern | expected
        "ppqp"    | "pq"    | [1, 2]
        "abbcabc" | "abc"   | [2, 3, 4]
        "abab"    | "ab"    | [0, 1, 2]
        "pq"      | "pq"    | [0]
    }
}
