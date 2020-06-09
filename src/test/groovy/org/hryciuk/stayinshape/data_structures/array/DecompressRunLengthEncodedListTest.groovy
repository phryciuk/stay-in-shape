package org.hryciuk.stayinshape.data_structures.array

import spock.lang.Specification

class DecompressRunLengthEncodedListTest extends Specification {

    def "should decompress run-length encoded list"(int[] input, int[] expected) {
        given:
        DecompressRunLengthEncodedList decompressRunLengthEncodedList = new DecompressRunLengthEncodedList()

        when:
        int[] actual = decompressRunLengthEncodedList.decompressRLElist(input)

        then:
        actual == expected

        where:
        input              | expected
        [1, 2, 3, 4]       | [2, 4, 4, 4]
        [1, 1, 2, 3]       | [1, 3, 3]
        [1, 1, 2, 3, 4, 5] | [1, 3, 3, 5, 5, 5, 5]

    }
}
