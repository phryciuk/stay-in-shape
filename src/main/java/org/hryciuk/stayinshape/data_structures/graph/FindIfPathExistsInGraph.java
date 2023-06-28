package org.hryciuk.stayinshape.data_structures.graph;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class FindIfPathExistsInGraph {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        // path u,u always exists if n >= 1
        if ( n >= 1 && source == destination) {
            return true;
        }
        // visited array
        boolean[] visited = new boolean[n];

        // adjacency list
        List<List<Integer>> adj = new ArrayList<>();

        // initialize adjacency list
        for (int i = 0; i < n; ++i) {
            adj.add(i, new ArrayList<>());
        }

        // create adjacency list
        for (int i = 0; i < edges.length; ++i) {
            // this is undirected graph so we need to store the edges both ways
            int[] edge = edges[i];
            List<Integer> first = adj.get(edge[0]);
            first.add(edge[1]);
            List<Integer> second = adj.get(edge[1]);
            second.add(edge[0]);

        }

        // bfs from the source vertex
        Deque<Integer> q = new LinkedList<>();
        q.add(source);
        while (!q.isEmpty()) {
            int current = q.pop();
            visited[current] = true;
            List<Integer> neighbors = adj.get(current);
            for (int i = 0; i < neighbors.size(); ++i) {
                if (!visited[neighbors.get(i)]) {
                    if (neighbors.get(i) == destination) {
                        return true;
                    }
                    q.add(neighbors.get(i));
                }
            }
        }
        return false;
    }
}
