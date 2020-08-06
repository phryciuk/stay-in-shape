package org.hryciuk.stayinshape.data_structures.array

import spock.lang.Specification

class FindTheDuplicateNumberTest extends Specification {
    def 'should find duplicates in an array'(int[] nums, int expected) {
        given:
        FindTheDuplicateNumber findTheDuplicateNumber = new FindTheDuplicateNumber()

        when:
        int actual = findTheDuplicateNumber.findDuplicatesFloyd(nums)

        then:
        actual == expected

        where:
        nums            | expected
        [1, 3, 4, 2, 2] | 2

    }
}
