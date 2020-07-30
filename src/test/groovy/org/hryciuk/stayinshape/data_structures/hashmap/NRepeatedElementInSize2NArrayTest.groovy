package org.hryciuk.stayinshape.data_structures.hashmap

import spock.lang.Specification

class NRepeatedElementInSize2NArrayTest extends Specification {

    def 'should work'(int[] arr, int expected) {
        given:
        NRepeatedElementInSize2NArray nArray = new NRepeatedElementInSize2NArray()

        when:
        int actual = nArray.repeatedNTimes(arr)

        then:
        actual == expected

        where:
        arr          | expected
        [8, 3, 2, 3] | 3
    }
}
