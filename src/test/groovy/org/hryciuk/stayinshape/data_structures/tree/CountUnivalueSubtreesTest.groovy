package org.hryciuk.stayinshape.data_structures.tree

import spock.lang.Specification

class CountUnivalueSubtreesTest extends Specification {

    def "should count how many unival subtrees there are"(Integer[] tree, int expected) {
        given:
        CountUnivalueSubtrees countUnivalueSubtrees = new CountUnivalueSubtrees()
        TreeNode root = TreeUtil.createFromArray(tree)
        when:
        def actual = countUnivalueSubtrees.countUnivalueSubtrees(root)

        then:
        expected == actual

        where:
        tree                     | expected
        [5, 1, 5, 5, 5, null, 5] | 4
        [1, 3, 2, 4, 5, null, 6] | 3
    }
}
