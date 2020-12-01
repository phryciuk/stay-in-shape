package org.hryciuk.stayinshape.data_structures.graph;

import java.util.*;

public class AlienDictionary {

    // time : O(C), where C = total length of all the words in the input list, added together.
    // space: O (1)
    public String alienOrder(String[] words) {
        int[] indegrees = new int[26];

        // build graph
        Map<Character, List<Character>> graph = new HashMap<>();
        for (String s : words) {
            for (int i = 0; i < s.length(); ++i) {
                graph.put(s.charAt(i), new ArrayList<>());
            }
        }

        // add edges and indegrees
        for (int i = 1; i < words.length; ++i) {
            String firstWord = words[i - 1];
            String secondWord = words[i];
            // In a valid alphabet, prefixes are always first
            // //check for cases like, ["wrtkj","wrt"];  it's invalid, because this input is not in sorted lexicographical order
            if (firstWord.length() > secondWord.length() && firstWord.startsWith(secondWord)) {
                return "";
            }
            int len = Math.min(firstWord.length(), secondWord.length());
            for (int j = 0; j < len; ++j) {
                char outgoing = firstWord.charAt(j);
                char incoming = secondWord.charAt(j);
                if (outgoing != incoming) {
                    indegrees[incoming - 'a']++;
                    graph.get(outgoing).add(incoming);
                    break;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        Deque<Character> q = new LinkedList<>();
        // find nodes of indegree = 0
        for (char c : graph.keySet()) {
            if (indegrees[c - 'a'] == 0) {
                q.add(c);
            }
        }

        // iterate through the queue
        while (!q.isEmpty()) {
            char current = q.poll();
            List<Character> edges = graph.get(current);
            for (char c : edges) {
                indegrees[c - 'a']--;
                if (indegrees[c - 'a'] == 0) {
                    q.add(c);
                }
            }
            sb.append(current);
        }

        return sb.length() == graph.size() ? sb.toString() : "";
    }
}
