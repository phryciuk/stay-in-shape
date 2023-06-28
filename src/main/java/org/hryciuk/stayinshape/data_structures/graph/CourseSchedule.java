package org.hryciuk.stayinshape.data_structures.graph;

import java.util.*;

public class CourseSchedule {
    // Kahn's algorithm
    // Great explanation: https://youtu.be/cIBFEhD77b4
    // Time: O(V+E)
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites == null || prerequisites.length == 0) {
            return true;
        }

        // initialize edges lists
        List<Integer>[] edges = new List[numCourses];
        for (int i = 0; i < edges.length; ++i) {
            edges[i] = new LinkedList<>();
        }

        // build adjacency list and indegrees array
        int[] indegrees = new int[numCourses];
        for (int i = 0; i < prerequisites.length; ++i) {
            int[] current = prerequisites[i];
            indegrees[current[0]]++;
            edges[current[1]].add(current[0]);
        }

        Queue<Integer> q = new LinkedList<>();
        // add nodes with indegrees of 0 to Queue
        for (int i = 0; i < indegrees.length; ++i) {
            if (indegrees[i] == 0) {
                q.add(i);
            }
        }
        int totalNumberOfEdges = prerequisites.length;
        while (!q.isEmpty()) {
            int polled = q.poll();
            // decrement indegrees of neighbouring nodes
            for (int i = 0; i < edges[polled].size(); ++i) {
                int destNode = edges[polled].get(i);
                indegrees[destNode]--;
                // add new 0 indegree nodes to Queue
                if (indegrees[destNode] == 0) {
                    q.add(destNode);
                }
                totalNumberOfEdges--;
            }
        }
        return totalNumberOfEdges == 0;
    }

    public boolean canFinish2(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adjacencyMap = new HashMap<>();
        int[] indegrees = new int[numCourses];

        // first we create the graph, and initialize every vertex with empty list to avoid nulls later on
        for (int i = 0; i < numCourses; ++i) {
            adjacencyMap.put(i, new ArrayList<>());
        }

        // create adjacency list (graph) and increase indegrees
        for (int[] edge : prerequisites) {
            List<Integer> adjacentNodes = adjacencyMap.get(edge[1]);
            adjacentNodes.add(edge[0]);
            adjacencyMap.put(edge[1], adjacentNodes);
            indegrees[edge[0]]++;
        }

        // look for nodes with indegree == 0
        Deque<Integer> q = new LinkedList<>();
        for (int i = 0; i < indegrees.length; ++i) {
            if (indegrees[i] == 0) {
                q.add(i);
            }
        }

        int totalNumberOfEdges = prerequisites.length;
        while(!q.isEmpty()) {
            Integer popped = q.pop();
            List<Integer> edges = adjacencyMap.get(popped);
            if (edges == null) {
                continue;
            }
            for (int i = 0; i < edges.size(); ++i) {
                indegrees[edges.get(i)]--;
                if (indegrees[edges.get(i)] == 0) {
                    q.add(edges.get(i));
                }
                totalNumberOfEdges--;
            }
        }
        return totalNumberOfEdges == 0;
    }
}
