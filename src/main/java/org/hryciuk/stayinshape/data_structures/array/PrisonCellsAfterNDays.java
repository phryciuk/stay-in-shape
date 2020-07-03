package org.hryciuk.stayinshape.data_structures.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PrisonCellsAfterNDays {

    public int[] prisonAfterNDays(int[] cells, int N) {
        // stringified array to index of occurrence
        Map<String, Integer> map = new HashMap<>();
        int cycleSize = 0;
        int start = 0; // loop start point
        boolean hasCycle = false;
        for (int i = 0; i < N; i++) {
            String entryKey = Arrays.toString(cells);
            if (!map.containsKey(entryKey)) {
                map.put(entryKey, i);
                cycleSize++;
            } else {
                hasCycle = true;
                // cycle is found, i.e. we have the same set of cells as after 1st iteration
                start = map.get(entryKey); // we find at which position cycle starts
                cycleSize = i - start; // we adjust cycle size
            }
            if (hasCycle) {
                N -= start; // we adjust the number of iterations to start of the cycle
                for (int k = 0; k < N % cycleSize; ++k) {
                    nextDayPrisonCells(cells);
                }
                return cells;
            }
            nextDayPrisonCells(cells);
        }
        return cells;
    }

    private void nextDayPrisonCells(int[] cells) {
        int prev = cells[0];
        for (int j = 1; j < 7; j++) {
            int currentVal = cells[j];
            int next = cells[j + 1];
            if (prev == 1 && next == 1) {
                cells[j] = 1;
            } else if (prev == 0 && next == 0) {
                cells[j] = 1;
            } else {
                cells[j] = 0;
            }
            prev = currentVal;
        }
        cells[0] = 0;
        cells[7] = 0;
    }
}
