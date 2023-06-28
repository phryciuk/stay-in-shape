package org.hryciuk.stayinshape.data_structures.heap

import spock.lang.Specification

class ExpiryPriorityCacheSpec extends Specification {
    def "should be a nice cache"() {
        given:
        ExpiryPriorityCache priorityExpiryCache = new ExpiryPriorityCache(5);
        priorityExpiryCache.setItem(new Item("A", "val1", 5, 100), 0);
        priorityExpiryCache.setItem(new Item("B", "val2", 15, 3), 0);
        priorityExpiryCache.setItem(new Item("C", "val3", 5, 10), 0);
        priorityExpiryCache.setItem(new Item("D", "val4", 1, 15), 0);
        priorityExpiryCache.setItem(new Item("E", "val5", 5, 150), 0);

        when:
        priorityExpiryCache.get("C");

        System.out.println(priorityExpiryCache.getKeys());

        priorityExpiryCache.evictItem(5);
        System.out.println(priorityExpiryCache.getKeys());

        priorityExpiryCache.evictItem(5);
        System.out.println(priorityExpiryCache.getKeys());

        priorityExpiryCache.evictItem(5);
        System.out.println(priorityExpiryCache.getKeys());

        priorityExpiryCache.evictItem(5);
        System.out.println(priorityExpiryCache.getKeys());

        then:
        1 == 1

    }
}
