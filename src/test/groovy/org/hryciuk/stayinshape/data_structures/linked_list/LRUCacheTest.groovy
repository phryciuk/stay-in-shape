package org.hryciuk.stayinshape.data_structures.linked_list

import spock.lang.Specification

class LRUCacheTest extends Specification {
    def 'LRU Cache should work'() {
        given:
        LRUCache cache = new LRUCache(2);

        when:
        cache.put(1, 1);
        cache.put(2, 2);

        then:
        cache.get(1) == 1;       // returns 1

        when:
        cache.put(3, 3);    // evicts key 2

        then:
        cache.get(2) == -1;       // returns -1 (not found)

        when:
        cache.put(4, 4);    // evicts key 1

        then:
        cache.get(1) == -1;       // returns -1 (not found)
        cache.get(3) == 3;       // returns 3
        cache.get(4) == 4;       // returns 4
    }
}
