package org.hryciuk.stayinshape.backtracking

import spock.lang.Specification

import static java.util.stream.Collectors.toList

class LetterCasePermutationTest extends Specification {
    def "should perform letter case permutation"(String input, List<String> expectedPermutations) {
        given:
        LetterCasePermutation permutations = new LetterCasePermutation()

        when:
        def actual = permutations.letterCasePermutation(input)

        then:
        actual.size() == expectedPermutations.size()
        actual.stream().filter({ s -> !expectedPermutations.contains(s) }).collect(toList()).size() == 0

        where:
        input   | expectedPermutations
        "a1b2"  | ["a1b2", "a1B2", "A1b2", "A1B2"]
        "3z4"   | ["3z4", "3Z4"]
        "12345" | ["12345"]
        "po"    | ["po", "pO", "Po", "PO"]
        "TB"    | ["tb", "tB", "Tb", "TB"]
    }

}
