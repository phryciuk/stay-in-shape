package org.hryciuk.stayinshape.data_structures.tree

import spock.lang.Specification

class SingleValuedSubtreesTest extends Specification {
    def 'should determine how many subtrees are single valued'(Integer[] treeAsArr, int expected) {

        given:
        SingleValuedSubtrees singleValuedSubtrees = new SingleValuedSubtrees()
        TreeNode root = TreeUtil.createFromArray(treeAsArr)

        when:
        int actual = singleValuedSubtrees.singleValuedSubtrees(root)

        then:
        actual == expected

        where:
        treeAsArr                      | expected
        [5, 1, 5, 5, 5, null, 5]       | 4
        [5, 4, 5, 4, 4, null, 5]       | 5
        [1, 1, 1, 2, 3, null, 4, 2, 2] | 5
        []                             | 0
        [1]                            | 1
    }
}
