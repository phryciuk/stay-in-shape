package org.hryciuk.stayinshape.data_structures.graph;

import java.util.*;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] incomingEdges = new int[numCourses];

        List<Integer>[] outgoingCourses = new List[numCourses];
        for (int i = 0; i < outgoingCourses.length; ++i) {
            outgoingCourses[i] = new LinkedList<>();
        }

        for (int[] pair : prerequisites) {
            incomingEdges[pair[0]]++;
            outgoingCourses[pair[1]].add(pair[0]);
        }

        Queue<Integer> q = new LinkedList<>();

        // we are adding nodes of indegree 0
        for (int i = 0; i < incomingEdges.length; ++i) {
            if (incomingEdges[i] == 0) {
                q.add(i);
            }
        }

        int numberOfEdges = prerequisites.length;
        while (!q.isEmpty()) {
            int current = q.poll();
            for (int outgoing : outgoingCourses[current]) {
                numberOfEdges--;
                incomingEdges[outgoing]--;
                if (incomingEdges[outgoing] == 0) {
                    q.add(outgoing);
                }
            }
        }
        return numberOfEdges == 0;
    }
}
