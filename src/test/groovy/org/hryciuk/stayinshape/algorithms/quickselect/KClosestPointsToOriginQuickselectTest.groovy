package org.hryciuk.stayinshape.algorithms.quickselect

import org.hryciuk.stayinshape.data_structures.heap.KClosestPointsToOrigin
import spock.lang.Specification
import spock.lang.Unroll

class KClosestPointsToOriginQuickselectTest extends Specification {

    @Unroll
    def "should return closes points to origin"(int[][] points, int k, int[][] expected) {
        given:
        KClosestPointsToOriginQuickselect kClosestPointsToOrigin = new KClosestPointsToOriginQuickselect()
        Map<String, Integer> act = new HashMap<>();
        Map<String, Integer> exp = new HashMap<>();

        when:
        int[][] actual = kClosestPointsToOrigin.kClosest(points, k);

        def expectedList = Arrays.asList(expected)
        for (int[] el : expectedList) {
            exp.put(buildKey(el), exp.getOrDefault(buildKey(el), 0) + 1);
        }
        def actualList = Arrays.asList(actual)
        for (int[] el : actualList) {
            act.put(buildKey(el), act.getOrDefault(buildKey(el), 0) + 1);
        }
        then:
        act.size() == exp.size()
        act.keySet() == exp.keySet()


        where:
        points                                                                                                        | k || expected
//        [[1, 3], [-2, 2]]                                                                                             | 1 || [[-2, 2]]
        [[3, 3], [5, -1], [-2, 4]]                                                                                    | 2 || [[3, 3], [-2, 4]]
//        [[3, 3], [5, -1], [-2, 4]]                                                                                    | 3 || [[3, 3], [-2, 4], [5, -1]]
//        [[68, 97], [34, -84], [60, 100], [2, 31], [-27, -38], [-73, -74], [-55, -39], [62, 91], [62, 92], [-57, -67]] | 5 || [[2, 31], [-27, -38], [-55, -39], [-57, -67], [34, -84]]
//        [[68, 97], [34, -84], [60, 100], [2, 31], [-27, -38], [-73, -74], [-55, -39], [62, 91], [62, 92], [-57, -67]] | 2 || [[2, 31], [-27, -38]]
//        [[68, 97], [34, -84], [60, 100], [2, 31], [-27, -38], [-73, -74], [-55, -39], [62, 91], [62, 92], [-57, -67]] | 1 || [[2, 31]]
//        [[0, 0], [1, 1], [2, 2]]                                                                                      | 2 || [[0, 0], [1, 1]]
//        [[1, 0], [2, 1], [3, 6], [-5, 2], [1, -4]]                                                                    | 3 || [[1, 0], [2, 1], [1, -4]]
//        [[0, 0], [0, 1], [4, 4], [5, 5], [6, 6], [7, 7], [1, 2], [8, 8], [9, 9], [3, 3]]                              | 3 || [[0, 0], [0, 1], [1, 2]]
    }

    private String buildKey(int[] el) {
        return "" + el[0] + "," + el[1];
    }

}
