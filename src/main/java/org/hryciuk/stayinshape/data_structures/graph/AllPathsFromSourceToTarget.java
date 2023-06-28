package org.hryciuk.stayinshape.data_structures.graph;

import java.util.ArrayList;
import java.util.List;

public class AllPathsFromSourceToTarget {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        // graph is empty; no paths
        if (graph.length == 0) {
            return new ArrayList<>();
        }
        // input is rather small, so we can go with adjacency matrix
        int size = graph.length;
        // 2 dimensional adjacency matrix
        boolean[][] adj = new boolean[size][size];

        // initialize adjacency matrix
        for (int i = 0; i < graph.length; ++i) {
            int[] edges = graph[i];
            if (edges.length > 0) {
                for (int j = 0; j < edges.length; ++j) {
                    adj[i][edges[j]] = true;
                }
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        backtrack(adj, result, current, 0);
        return result;
    }

    private void backtrack(boolean[][] adj, List<List<Integer>> result, List<Integer> path, int index) {
        path.add(index);
        // last element; this is one of the paths
        if (index == adj.length - 1) {
            result.add(new ArrayList<>(path));
        }
        boolean[] neighbors = adj[index];
        for (int i = 0; i < neighbors.length; ++i) {
            if (neighbors[i]) {
                backtrack(adj, result, path, i);
            }
        }
        path.remove(path.size() - 1);
    }
}
