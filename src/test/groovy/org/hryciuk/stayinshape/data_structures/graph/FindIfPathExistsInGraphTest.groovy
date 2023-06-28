package org.hryciuk.stayinshape.data_structures.graph

import spock.lang.Specification

class FindIfPathExistsInGraphTest extends Specification {
    def 'check if path exists'(int numberOfNodes, int[][] edges, int source, int destination, boolean expected) {
        given:
        FindIfPathExistsInGraph findIfPathExistsInGraph = new FindIfPathExistsInGraph()

        when:
        boolean actual = findIfPathExistsInGraph.validPath(numberOfNodes, edges, source, destination)

        then:
        actual == expected

        where:
        numberOfNodes | edges                                    || source || destination || expected
        3             | [[0, 1], [1, 2], [2, 0]]                 || 0      || 2           || true
        3             | [[0, 1], [1, 2], [2, 0]]                 || 0      || 1           || true
        3             | [[0, 1], [1, 2], [2, 0]]                 || 0      || 0           || true
        6             | [[0, 1], [0, 2], [3, 5], [5, 4], [4, 3]] || 0      || 5           || false
        6             | [[0, 1], [0, 2], [3, 5], [5, 4], [4, 3]] || 0      || 3           || false
        6             | [[0, 1], [0, 2], [3, 5], [5, 4], [4, 3]] || 0      || 2           || true
        6             | [[0, 1], [0, 2], [3, 5], [5, 4], [4, 3]] || 3      || 5           || true
    }
}
