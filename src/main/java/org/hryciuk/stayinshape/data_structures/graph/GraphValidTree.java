package org.hryciuk.stayinshape.data_structures.graph;

import java.util.*;

public class GraphValidTree {
    // Given n nodes labeled from 0 to n - 1 and a list of undirected edges
    // (each edge is a pair of nodes), write a function to check whether
    // these edges make up a valid tree.

    // tree is am undirected acyclic graph. Tree also needs to be connected (consists of only 1 component)
    // We could do it in 2 ways:
    // - dfs or bfs and check if has cycle
    // - union find
    public boolean validTreeBFS(int n, int[][] edges) {
        boolean[] visited = new boolean[n];

        // initialize graph
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            graph.put(i, new ArrayList<>());
        }

        int[] indegrees = new int[n];
        // build graph
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        // BFS
        Deque<Integer> q = new LinkedList<>();
        q.add(0);
        while (!q.isEmpty()) {
            int current = q.pop();
            if (visited[current]) {
                return false;
            }
            visited[current] = true;

            List<Integer> neighbors = graph.get(current);
            for (int i = 0; i < neighbors.size(); ++i) {
                if (!visited[neighbors.get(i)]) {
                    q.add(neighbors.get(i));
                }
            }
        }
        // fully connected
        for(boolean b: visited){
            if(!b)
                return false;
        }

        return true;
    }

    public boolean validTreeDFS(int n, int[][] edges) {
        boolean[] visited = new boolean[n];

        // initialize graph
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            graph.put(i, new ArrayList<>());
        }

        // build graph
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        boolean dfsResult = dfs(graph, visited, edges[0][0], -1);
        for (int i = 0; i < visited.length; ++i) {
            if (!visited[i]) return false;
        }
        return dfsResult;
    }

    private boolean dfs(Map<Integer, List<Integer>> graph, boolean[] visited, int current, int parent) {
        if (visited[current]) {
            return false;
        }
        visited[current] = true;
        List<Integer> neighbors = graph.get(current);
        for (int i = 0; i < neighbors.size(); ++i) {
            if (neighbors.get(i) == parent) {
                continue; // we ignore calling the same thing over and over.
            }
            if (!dfs(graph, visited, neighbors.get(i), current)) {
                return false;
            }
        }
        return true;
    }

}
