package org.hryciuk.stayinshape.data_structures.array

import spock.lang.Specification

class PrisonCellsAfterNDaysTest extends Specification {

    def "should return prison cells after n days"(int[] cells, int N, int[] expected) {
        given:
        PrisonCellsAfterNDays prisonCellsAfterNDays = new PrisonCellsAfterNDays();

        when:
        int[] actual = prisonCellsAfterNDays.prisonAfterNDays(cells, N);

        then:
        actual == expected

        where:
        cells                    | N          | expected
        [1, 0, 0, 1, 0, 0, 1, 0] | 1000000000 | [0, 0, 1, 1, 1, 1, 1, 0]
        [0, 1, 0, 1, 1, 0, 0, 1] | 7          | [0, 0, 1, 1, 0, 0, 0, 0]
        [0, 1, 1, 1, 0, 0, 0, 0] | 99         | [0, 0, 1, 0, 0, 1, 1, 0]
    }
}
