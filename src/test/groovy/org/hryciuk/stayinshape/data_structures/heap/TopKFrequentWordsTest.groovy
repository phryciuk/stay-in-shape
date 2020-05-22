package org.hryciuk.stayinshape.data_structures.heap

import spock.lang.Specification

class TopKFrequentWordsTest extends Specification {

    def "should return k top frequent words"(String[] input, int k, String[] expected) {

        given:
        TopKFrequentWords topKFrequentWords = new TopKFrequentWords()

        when:
        List<String> actual = topKFrequentWords.topKFrequent(input, k)

        then:
        Arrays.asList(expected).size() == actual.size()
        for (int i = 0; i < expected.length; ++i) {
            assert expected[i] == actual.get(i)
        }

        where:
        input                                                                   | k || expected
        ["i", "love", "leetcode", "i", "love", "coding"]                        | 2 || ["i", "love"]
        ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"] | 4 || ["the", "is", "sunny", "day"]
        ["i", "love", "coding", "i", "love", "leetcode"]                        | 3 || ["i", "love", "coding"]
        ["i", "love", "leetcode", "i", "love", "coding"]                        | 1  | ["i"]

    }
}
