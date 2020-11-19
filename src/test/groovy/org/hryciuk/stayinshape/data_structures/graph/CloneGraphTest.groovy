package org.hryciuk.stayinshape.data_structures.graph

import spock.lang.Specification

class CloneGraphTest extends Specification {

    def " should clone a graph"() {
        given:
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        node1.neighbors.addAll(node2, node4);
        node2.neighbors.addAll(node1, node3);
        node3.neighbors.addAll(node2, node4);
        node4.neighbors.addAll(node1, node3);

        when:
        CloneGraph cloneGraph = new CloneGraph()

        then:
        Node cloned = cloneGraph.cloneGraph(node1)
        int i = 0;
    }
}
