package org.hryciuk.stayinshape.data_structures.hashmap

import spock.lang.Specification

class DesignHashMapTest extends Specification {
    def "should have hashmap behaviour"() {
        given:
        DesignHashMap hashMap = new DesignHashMap()

        when:
        hashMap.put(1,1)
        hashMap.put(2,2)

        then:
        hashMap.get(1) == 1
        hashMap.get(3) == -1

        when:
        hashMap.put(2,1)

        then:
        hashMap.get(2) == 1

        when:
        hashMap.remove(2)

        then:
        hashMap.get(2) == -1
    }

    def "should have hashmap behaviour 2"() {
        given:
        DesignHashMap hashMap = new DesignHashMap()

        when:
        hashMap.remove(13)

        then:
        hashMap.get(13) == -1

    }
}