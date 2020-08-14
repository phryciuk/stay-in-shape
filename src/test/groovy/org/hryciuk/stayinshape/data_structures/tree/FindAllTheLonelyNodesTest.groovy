package org.hryciuk.stayinshape.data_structures.tree

import spock.lang.Specification

class FindAllTheLonelyNodesTest extends Specification {

    def 'should find all the lonely nodes in a tree'(Integer[] treeArr, List<Integer> expected) {
        given:
        FindAllTheLonelyNodes findAllTheLonelyNodes = new FindAllTheLonelyNodes()
        TreeNode root = TreeUtil.createFromArray(treeArr)

        when:
        List<Integer> actual = findAllTheLonelyNodes.findAllLonelyNodes(root)

        then:
        actual.containsAll(expected)

        where:
        treeArr                                                                  | expected
        [1, 2, 3, null, 4]                                                       | [4]
        [7, 1, 4, 6, null, 5, 3, null, null, null, null, null, 2]                | [6, 2]
        [11, 99, 88, 77, null, null, 66, 55, null, null, 44, 33, null, null, 22] | [77, 55, 33, 66, 44, 22]
        [197]                                                                    | []
        [31, null, 78, null, 28]                                                 | [78, 28]

    }

}
