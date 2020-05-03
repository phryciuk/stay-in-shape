package org.hryciuk.stayinshape.data_structures.array

import spock.lang.Specification

class MaxAreaOfIslandSpec extends Specification {

    def "should calculate the max area of island in a 2 dimensional array"() {

        given:
        MaxAreaOfIsland maxAreaOfIsland = new MaxAreaOfIsland()
        int[][] islands = [[1,1,0,0,0],[1,1,0,0,0],[0,0,0,1,1],[0,0,0,1,1]]
        int [][] islands2 = [[0,0,1,0,0,0,0,1,0,0,0,0,0],
                             [0,0,0,0,0,0,0,1,1,1,0,0,0],
                             [0,1,1,0,1,0,0,0,0,0,0,0,0],
                             [0,1,0,0,1,1,0,0,1,0,1,0,0],
                             [0,1,0,0,1,1,0,0,1,1,1,0,0],
                             [0,0,0,0,0,0,0,0,0,0,1,0,0],
                             [0,0,0,0,0,0,0,1,1,1,0,0,0],
                             [0,0,0,0,0,0,0,1,1,0,0,0,0]]

        when:
        def maxIsland = maxAreaOfIsland.maxAreaOfIsland(islands)

        then:
        maxIsland == 4
    }
}
