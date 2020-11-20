package org.hryciuk.stayinshape.data_structures.tree


import spock.lang.Specification
import spock.lang.Unroll

import static org.hryciuk.stayinshape.data_structures.tree.TreeUtil.createFromArray

class MaxPathSumTest extends Specification {
    @Unroll
    def "should return max path sum"(Integer[] tree, int expected) {
        given:
        MaxPathSum maxPathSum = new MaxPathSum()
        def treeNode = createFromArray(tree as Integer[])

        when:
        int actual = maxPathSum.maxPathSum(treeNode)

        then:
        actual == expected

        where:
        tree                              || expected
        [1, 2, 3]                         || 6
        [-10, 9, 20, null, null, 15, 7]   || 42
        [1, 2, 3, 4, 5, 6, 7]             || 18
        [-100, 2, 3, 4, 5, 6, 7]          || 16
        [-100, null, 3, null, 5, null, 7] || 15
        [-3]                              || -3
        [-2, -1]                          || -1
        [1, 2]                            || 3
    }
}
