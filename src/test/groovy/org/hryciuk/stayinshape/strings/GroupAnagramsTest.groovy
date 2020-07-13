package org.hryciuk.stayinshape.strings

import spock.lang.Specification

class GroupAnagramsTest extends Specification {

    def 'should group anagrams together'(String[] input, List<List<String>> expected) {
        given:
        GroupAnagrams groupAnagrams = new GroupAnagrams()

        when:
        def actual = groupAnagrams.groupAnagrams(input)

        then:
        actual == expected

        where:
        input                                      | expected
        ["eat", "tea", "tan", "ate", "nat", "bat"] | [
                ["ate", "eat", "tea"],
                ["nat", "tan"],
                ["bat"]
        ]
    }
}
