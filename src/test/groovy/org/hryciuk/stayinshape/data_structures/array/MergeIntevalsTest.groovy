package org.hryciuk.stayinshape.data_structures.array

import spock.lang.Specification
import spock.lang.Unroll

class MergeIntevalsTest extends Specification {

    @Unroll
    def 'should merge overlapping intervals'(int[][] intervals, int[][] expected) {
        given:
        MergeIntevals mergeIntevals = new MergeIntevals()

        when:
        int[][] actual = mergeIntevals.merge(intervals)

        then:
        Arrays.deepEquals(actual, expected)

        where:
        intervals                                   || expected
        [[1, 3], [2, 6], [8, 10], [15, 18]]         || [[1, 6], [8, 10], [15, 18]]
        [[1, 3], [2, 6], [6, 7], [8, 10], [10, 18]] || [[1, 7], [8, 18]]
        [[1, 3], [2, 6], [6, 7], [8, 10], [15, 18]] || [[1, 7], [8, 10], [15, 18]]
        [[1, 4], [4, 5]]                            || [[1, 5]]
        [[1, 4], [5, 7]]                            || [[1, 4], [5, 7]]
        [[1, 4], [0, 4]]                            || [[0, 4]]
        [[1, 4], [2, 3]]                            || [[1, 4]]
    }
}
