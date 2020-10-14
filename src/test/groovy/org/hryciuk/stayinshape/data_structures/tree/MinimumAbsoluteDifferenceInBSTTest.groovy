package org.hryciuk.stayinshape.data_structures.tree

import spock.lang.Specification
import spock.lang.Unroll

class MinimumAbsoluteDifferenceInBSTTest extends Specification {
    @Unroll
    def "should determine what is minimum absolute difference"(Integer[] tree, int expected) {
        given:
        TreeNode root = TreeUtil.createFromArray(tree);
        MinimumAbsoluteDifferenceInBST minimumAbsoluteDifferenceInBST = new MinimumAbsoluteDifferenceInBST()

        when:
        int actual = minimumAbsoluteDifferenceInBST.getMinimumDifference(root)

        then:
        actual == expected

        where:
        tree            | expected
        [5, 4, 7]       | 1
        [1, null, 3, 2] | 1
    }
}
