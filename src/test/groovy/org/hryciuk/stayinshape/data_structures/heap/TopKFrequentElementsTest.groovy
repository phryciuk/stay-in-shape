package org.hryciuk.stayinshape.data_structures.heap

import spock.lang.Specification

class TopKFrequentElementsTest extends Specification {

    def 'should return k most frequent elements from a stream'(int[] input, int k, int[] expected) {
        given:
        TopKFrequentElements topKFrequentElements = new TopKFrequentElements()

        when:
        def actual = topKFrequentElements.topKFrequent(input, k)

        then:
        Arrays.asList(actual).size() == expected.length
        Arrays.asList(actual).containsAll(Arrays.asList(expected))

        where:
        input                                                                       | k | expected
        [1, 1, 1, 2, 2, 3]                                                          | 2 | [1, 2]
        [1, 1, 1, 2, 2, 3, 3, 3, 3, 3, 31, 2, 5, 2, 2, 2, 2, 6, 44, 3, 6, 7, 8, 42] | 2 | [2, 3]
        [5, 6, 3, 7, 1, 3, 2, 6, 3, 6, 9]                                           | 4 | [5, 2, 3, 6]

    }
}
