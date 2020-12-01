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
}
