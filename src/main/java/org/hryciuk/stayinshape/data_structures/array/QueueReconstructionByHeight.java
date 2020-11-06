package org.hryciuk.stayinshape.data_structures.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/queue-reconstruction-by-height/
 */
public class QueueReconstructionByHeight {
    public int[][] reconstructQueue(int[][] people) {
        // first we sort by height descending.
        // if the height is the same then we sort by number of people before that person ascending
        Arrays.sort(people, (n1, n2) -> (n2[0] == n1[0]) ? n1[1] - n2[1] : n2[0] - n1[0]);
        List<int[]> res = new ArrayList<>();
        for (int[] p : people) {
            res.add(p[1], p);
        }
        return res.toArray(new int[people.length][2]);
    }
}
