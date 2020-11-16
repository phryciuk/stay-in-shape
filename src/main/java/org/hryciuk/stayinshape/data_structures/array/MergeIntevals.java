package org.hryciuk.stayinshape.data_structures.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntevals {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }
        Arrays.sort(intervals, (arr1, arr2) -> Integer.compare(arr1[0], arr2[0]));

        List<int[]> result = new ArrayList<>();
        int[] newInterval = intervals[0];
        result.add(newInterval);
        for (int i = 1; i < intervals.length; ++i) {
            int[] current = intervals[i];
            if (current[0] <= newInterval[1]) {
                newInterval[1] = Math.max(newInterval[1], current[1]);
            } else {
                newInterval = current;
                result.add(newInterval);
            }
        }
        return result.toArray(new int[result.size()][2]);
    }
}
