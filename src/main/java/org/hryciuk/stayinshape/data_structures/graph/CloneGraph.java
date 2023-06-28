package org.hryciuk.stayinshape.data_structures.graph;

import java.util.*;

public class CloneGraph {

    // HashMap for storing cloned nodes
    // Queue for processing the nodes of the original graph. BFS over the original graph.
    // time O(V + E) | space O(V)
    public Node cloneGraph(Node root) {
        if (root == null) {
            return null;
        }

        Map<Integer, Node> clones = new HashMap<>();
        Node clonedRoot = new Node(root.val);
        clones.put(root.val, clonedRoot);
        Deque<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            Node current = q.poll();
            Node clone = clones.get(current.val);
            List<Node> neighbors = current.neighbors;
            for (int i = 0; i < neighbors.size(); ++i) {
                Node currentNeighbor = neighbors.get(i);
                if (clones.get(currentNeighbor.val) != null) {
                    clone.neighbors.add(clones.get(currentNeighbor.val));
                } else {
                    Node clonedNeighbor = new Node(currentNeighbor.val);
                    q.add(currentNeighbor);
                    clones.put(currentNeighbor.val, clonedNeighbor);
                    clone.neighbors.add(clonedNeighbor);
                }
            }
        }
        return clonedRoot;
    }

}
