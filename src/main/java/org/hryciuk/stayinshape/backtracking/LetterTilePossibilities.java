package org.hryciuk.stayinshape.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 1079. Letter Tile Possibilities
 * Medium
 *
 * You have a set of tiles, where each tile has one letter tiles[i] printed on it.  Return the number of possible non-empty sequences of letters you can make.
 *
 * Example 1:
 *
 * Input: "AAB"
 * Output: 8
 * Explanation: The possible sequences are "A", "B", "AA", "AB", "BA", "AAB", "ABA", "BAA".
 *
 * Example 2:
 *
 * Input: "AAABBC"
 * Output: 188
 *
 *
 * Note:
 *
 *     1 <= tiles.length <= 7
 *     tiles consists of uppercase English letters.
 */
public class LetterTilePossibilities {

    private List<String> result = new ArrayList<>();

    public int numTilePossibilities(String tiles) {
        int numberOfPossibilities = 0;
        char[] chars = tiles.toCharArray();
        return 0;
    }

    private void generatePossibilities(char[] chars, int position) {
        if (position == chars.length) {
//            result.add()
        }
    }
}
