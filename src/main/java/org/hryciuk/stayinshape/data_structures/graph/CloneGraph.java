package org.hryciuk.stayinshape.data_structures.graph;

import java.util.*;

public class CloneGraph {
    public Node cloneGraph(Node node) {
        Map<Integer, Node> clonedNodes = new HashMap<>();
        Deque<Node> q = new LinkedList<>();
        q.add(node);
        Node clone = new Node(node.val);
        clonedNodes.put(node.val, clone);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; ++i) {
                Node current = q.poll();
                Node clonedCurrent = clonedNodes.get(current.val);
                for (int j = 0; j < current.neighbors.size(); ++j) {
                    Node neighbor = current.neighbors.get(j);
                    if (clonedNodes.containsKey(neighbor.val)) {
                        Node cloneOfCurrent = clonedNodes.get(neighbor.val);
                        clonedCurrent.neighbors.add(cloneOfCurrent);
                    } else {
                        Node cloneOfCurrent = new Node(neighbor.val);
                        q.add(neighbor);
                        clonedNodes.put(cloneOfCurrent.val, cloneOfCurrent);
                        clonedCurrent.neighbors.add(cloneOfCurrent);
                    }
                }
            }
        }
        return clone;
    }
}
