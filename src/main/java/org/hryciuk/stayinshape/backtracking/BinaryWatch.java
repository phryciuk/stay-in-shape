package org.hryciuk.stayinshape.backtracking;

import java.util.ArrayList;
import java.util.List;

public class BinaryWatch {

    public List<String> readBinaryWatch(int num) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < 12; ++i) {
            for (int j = 0; j < 60; ++j) {
                if (countSetBits(i) + countSetBits(j) == num) {
                    result.add(String.format("%d:%02d", i, j));
                }
            }
        }
        return result;
    }

    // Counts the number of bits that are set up with value 1
    private int countSetBits(int x) {
        int setBits = 0;
        while (x != 0) {
            x = x & (x -1);
            setBits++;
        }
        return setBits;
    }
}
