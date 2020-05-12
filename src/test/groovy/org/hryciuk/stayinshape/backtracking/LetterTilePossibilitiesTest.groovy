package org.hryciuk.stayinshape.backtracking

import spock.lang.Specification

class LetterTilePossibilitiesTest extends Specification {
    def "should generate letter tile possibilities"(String tiles, int numberOfPossibilities) {
        given:
        LetterTilePossibilities possibilities = new LetterTilePossibilities()

        when:
        def actual = possibilities.numTilePossibilities(tiles)

        then:
        numberOfPossibilities == actual

        where:
        tiles     | numberOfPossibilities
        "AAB"     | 8
        "ABBA"    | 18
        "POIASDP" | 7012


    }
}
