package org.hryciuk.stayinshape.data_structures.graph

import spock.lang.Specification

class NumberOfConnectedComponentsInAnUndirectedGraphTest extends Specification {
    def "should return number of components in an undirected graph"(int n, int[][] edges, int expected) {

        given:
        NumberOfConnectedComponentsInAnUndirectedGraph number = new NumberOfConnectedComponentsInAnUndirectedGraph()

        when:
        int actual = number.countComponents(n, edges)

        then:
        actual == expected

        where:
        n | edges                            | expected
        5 | [[0, 1], [1, 2], [3, 4]]         | 2
        5 | [[0, 1], [1, 2], [2, 3], [3, 4]] | 1
    }
}
