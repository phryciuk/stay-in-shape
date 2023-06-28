package org.hryciuk.stayinshape.data_structures.graph

import spock.lang.Specification

class GraphValidTreeTest extends Specification {
    def 'check if graph is valid tree'(int[][] edges, int n, boolean expected) {
        given:
        GraphValidTree graphValidTree = new GraphValidTree()

        when:
        boolean actual = graphValidTree.validTreeBFS(n, edges)

        then:
        actual == expected

        where:
        n | edges                                    || expected
        5 | [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]] || false
        5 | [[0, 1], [0, 2], [0, 3], [1, 4]]         || true
    }
}
