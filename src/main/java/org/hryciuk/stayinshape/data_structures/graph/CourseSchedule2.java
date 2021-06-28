package org.hryciuk.stayinshape.data_structures.graph;

import java.util.*;

public class CourseSchedule2 {
    // Kahn's algorithm
    // Great explanation: https://youtu.be/cIBFEhD77b4
    // Time: O(V+E)
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegrees = new int[numCourses];

        // initialize edges array
        List<Integer>[] edges = new List[numCourses];
        for (int i = 0; i < edges.length; ++i) {
            edges[i] = new ArrayList<>();
        }

        // build adjacency list and indegree arrays
        for (int i = 0; i < prerequisites.length; ++i) {
            int[] current = prerequisites[i];
            indegrees[current[0]]++;
            edges[current[1]].add(current[0]);
        }

        Deque<Integer> q = new LinkedList<>();
        // find 0 indegree nodes
        for (int i = 0; i < indegrees.length; ++i) {
            if (indegrees[i] == 0) {
                q.add(i);
            }
        }

        int totalEdges = prerequisites.length;
        int[] result = new int[numCourses];
        int index = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int i = 0; i < edges[cur].size(); ++i) {
                int destNode = edges[cur].get(i);
                indegrees[destNode]--;
                totalEdges--;
                if (indegrees[destNode] == 0) {
                    q.add(destNode);
                }
            }
            result[index++] = cur;
        }
        if (totalEdges == 0) {
            return result;
        } else {
            return new int[0];
        }
    }

    public int[] canSchedule(int numCourses, int[][] prerequisites) {
        // initialize graph
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < numCourses; ++i) {
            graph.put(i, new ArrayList<>());
        }

        // indegree array
        int[] indegrees = new int[numCourses];

        // build graph and indegrees
        for (int i = 0; i < prerequisites.length; ++i) {
            int[] prerequisite = prerequisites[i];
            graph.get(prerequisite[1]).add(prerequisite[0]);
            indegrees[prerequisite[0]]++;
        }
        Deque<Integer> q = new LinkedList<>();

        // find nodes with indegree of 0
        for (int i = 0; i < indegrees.length; ++i) {
            if (indegrees[i] == 0) {
                q.add(i);
            }
        }

        int totalEdges = prerequisites.length;
        int[] result = new int[numCourses];
        int index = 0;
        while (!q.isEmpty()) {
            int node = q.poll();
            List<Integer> edges = graph.get(node);
            for (int i = 0; i < edges.size(); ++i) {
                int currentEdge = edges.get(i);
                indegrees[currentEdge]--;
                if (indegrees[currentEdge] == 0) {
                    q.add(currentEdge);
                }
                totalEdges--;
            }
            result[index++] = node;
        }
        return totalEdges == 0 ? result : new int[]{};
    }
}
