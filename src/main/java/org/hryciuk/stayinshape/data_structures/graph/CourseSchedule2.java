package org.hryciuk.stayinshape.data_structures.graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule2 {
    // Kahn's algorithm
    // Great explanation: https://youtu.be/cIBFEhD77b4
    // Time: O(V+E)
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] result = new int[numCourses];
        int[] indegrees = new int[numCourses];

        // initialize edges array
        List<Integer>[] edges = new List[numCourses];
        for (int i = 0; i < edges.length; ++i) {
            edges[i] = new LinkedList<>();
        }

        // build adjacency list and indegree arrays
        for (int i = 0; i < prerequisites.length; ++i) {
            int[] current = prerequisites[i];
            indegrees[current[0]]++;
            edges[current[1]].add(current[0]);
        }

        Queue<Integer> q = new LinkedList<>();

        // find nodes of indegree 0
        for (int i = 0; i < indegrees.length; i++) {
            if (indegrees[i] == 0) {
                q.add(i);
            }
        }

        int totalNumberOfEdges = prerequisites.length;
        int index = 0;
        while (!q.isEmpty()) {
            int polled = q.poll();
            for (int edge : edges[polled]) {
                indegrees[edge]--;
                totalNumberOfEdges--;
                if (indegrees[edge] == 0) {
                    q.add(edge);
                }
            }
            result[index] = polled;
            index++;
        }

        if (totalNumberOfEdges != 0) {
            return new int[0];
        } else {
            return result;
        }
    }
}
