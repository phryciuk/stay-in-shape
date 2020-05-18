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

    def "should delete a root node from max heap"() {
        given:
        int[] heap = [40, 35, 30, 15, 10, 25, 5]
        MaxHeap maxHeap = new MaxHeap(7, heap.size(), heap)

        when:
        maxHeap.removeFromHeap();

        then:
        maxHeap.getHeap() == [35, 15, 30, 5, 10, 25]
    }
}
