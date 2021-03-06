package org.hryciuk.stayinshape.backtracking


import spock.lang.Specification
import spock.lang.Unroll

class PermutationsTest extends Specification {

@Unroll
def "should permute input array elements"(int[] input, int[][] expectedPermutations) {
    given:
    Permutations permutations = new Permutations()

    when:
    def actual = permutations.permutations(input)

    then:
    expectedPermutations == actual

    where:
    input     | expectedPermutations
    [1, 2, 3] | [
            [1, 2, 3],
            [1, 3, 2],
            [2, 1, 3],
            [2, 3, 1],
            [3, 1, 2],
            [3, 2, 1]
    ]


}

}
