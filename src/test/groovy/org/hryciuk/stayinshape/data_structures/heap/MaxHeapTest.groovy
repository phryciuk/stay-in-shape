package org.hryciuk.stayinshape.data_structures.heap

import spock.lang.Specification

class MaxHeapTest extends Specification {

    def "should insert to max heap"() {
        given:
        int[] heap = [40, 35, 15, 30, 10, 12, 6, 5, 20]
        MaxHeap maxHeap = new MaxHeap(9, heap.size(), heap)

        when:
        maxHeap.insertToMaxHeap(50)

        then:
        maxHeap.getHeap() == [50, 40, 35, 30, 15, 12, 6, 5, 20, 10]
    }
}
