package org.hryciuk.stayinshape.algorithms.binary_search

import spock.lang.Specification

class TimeBasedKeyValueStoreTest extends Specification {
    def "should test Time Based key value store"() {
        given:
        TimeBasedKeyValueStore tmkvs = new TimeBasedKeyValueStore()

        when:
        tmkvs.set("foo", "bar", 1)

        then:
        tmkvs.get("foo", 1) == "bar"
        tmkvs.get("foo", 3) == "bar"

        when:
        tmkvs.set("foo", "bar2", 4)

        then:
        tmkvs.get("foo", 4) == "bar2"
        tmkvs.get("foo", 5) == "bar2"

    }
}
