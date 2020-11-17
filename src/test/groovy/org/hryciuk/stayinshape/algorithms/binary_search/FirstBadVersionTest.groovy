package org.hryciuk.stayinshape.algorithms.binary_search

import spock.lang.Specification

class FirstBadVersionTest extends Specification {
    def "should determine what is the first version"(int currentVersion, int badVersion) {
        given:
        FirstBadVersion firstBadVersion = new FirstBadVersion()

        when:
        firstBadVersion.entry(currentVersion, badVersion)
        int actual = firstBadVersion.firstBadVersion(currentVersion)

        then:
        actual == badVersion

        where:
        currentVersion | badVersion
        5              | 4
        7              | 1
        7              | 3
        7              | 7
        6              | 2

    }
}
