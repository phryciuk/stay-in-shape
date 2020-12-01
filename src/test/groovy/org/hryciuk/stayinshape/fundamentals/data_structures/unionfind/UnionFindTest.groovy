package org.hryciuk.stayinshape.fundamentals.data_structures.unionfind

import spock.lang.Specification

class UnionFindTest extends Specification {
    def "should determine how many components there are"(int n, int[][] edges, int expectedNumberOfComponents, boolean hasCycle) {
        given:
        UnionFind unionFind = new UnionFind(n)

        when:
        for (int[] edge : edges) {
            unionFind.unify(edge[0], edge[1])
        }

        then:
        unionFind.components() == expectedNumberOfComponents
        unionFind.hasCycle() == hasCycle

        where:
        n | edges                                    | expectedNumberOfComponents | hasCycle
        5 | [[0, 1], [0, 2], [0, 3], [1, 4]]         | 1                          | false
        5 | [[0, 1], [1, 2], [3, 4]]                 | 2                          | false
        5 | [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]] | 1                          | true
    }
}
