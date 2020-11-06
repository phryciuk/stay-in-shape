package org.hryciuk.stayinshape.data_structures.array

import spock.lang.Specification

class QueueReconstructionByHeightTest extends Specification {
    def 'Should reconstruct the queue by height'(int[][] input, int[][] expected) {
        given:
        QueueReconstructionByHeight queueReconstructionByHeight = new QueueReconstructionByHeight()

        when:
        int[][] actual = queueReconstructionByHeight.reconstructQueue(input)

        then:
        Arrays.equals(actual, expected)

        where:
        input                                            || expected
        [[7, 0], [4, 4], [7, 1], [5, 0], [6, 1], [5, 2]] || [[5, 0], [7, 0], [5, 2], [6, 1], [4, 4], [7, 1]]
    }
}
