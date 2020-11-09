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
}
