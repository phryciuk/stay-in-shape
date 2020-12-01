package org.hryciuk.stayinshape.data_structures.graph

import spock.lang.Specification

class AlienDictionaryTest extends Specification {
    def "should return valid order of letter"(String[] words, String expected) {
        given:
        AlienDictionary alienDictionary = new AlienDictionary()

        when:
        String actual = alienDictionary.alienOrder(words)

        then:

        actual == expected

        where:
        // UWAGA. Te testy moga failowac bo kolejnosc moze byc rozna
        words                               || expected
        ["wrt", "wrf", "er", "ett", "rftt"] || "wertf"
        ["z", "x"]                          || "zx"
        ["z", "x", "z"]                     || ""
        ["wrt"]                             || "rtw"
        ["wrt", "wrt"]                      || "rtw"
        ["wrt", "pep"]                      || "rtewp"
        ["zy", "zx"]                        || "yzx"
        ["ab", "adc"]                       || "abcd"
        ["ac", "ab", "zc", "zb"]            || "aczb"

    }
}
