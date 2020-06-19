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
        maxHeap.getHeap() == [50, 40, 15, 30, 35, 12, 6, 5, 20, 10]
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

    def 'should max-heapify an array'(int[] input, int[] expected) {
        when:
        int[] actual = MaxHeap.buildMaxHeap(input);

        then:
        Arrays.equals(actual, expected)

        where:
        input                       | expected
        [5, 10, 30, 20, 35, 40, 15] | [40, 35, 30, 20, 10, 5, 15]
    }
}
