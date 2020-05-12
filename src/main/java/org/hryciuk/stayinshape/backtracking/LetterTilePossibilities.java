package org.hryciuk.stayinshape.backtracking;

/**
 * 1079. Letter Tile Possibilities
 * Medium
 * <p>
 * You have a set of tiles, where each tile has one letter tiles[i] printed on it.  Return the number of possible non-empty sequences of letters you can make.
 * <p>
 * Example 1:
 * <p>
 * Input: "AAB"
 * Output: 8
 * Explanation: The possible sequences are "A", "B", "AA", "AB", "BA", "AAB", "ABA", "BAA".
 * <p>
 * Example 2:
 * <p>
 * Input: "AAABBC"
 * Output: 188
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= tiles.length <= 7
 * tiles consists of uppercase English letters.
 */

// https://leetcode.com/problems/letter-tile-possibilities/discuss/385144/3-solution-or-Optimisations-or-Java-or-Thought-Process
public class LetterTilePossibilities {

    private int[] numberOfOccurrences;
    private int result = 0;

    public int numTilePossibilities(String tiles) {
        if (tiles == null || tiles.isEmpty()) {
            return result;
        }
        numberOfOccurrences = new int[26];
        countNumberOfLetters(tiles);
        backtrack();
        return result;
    }

    private void countNumberOfLetters(String tiles) {
        for (int i = 0; i < tiles.length(); ++i) {
            char c = tiles.charAt(i);
            numberOfOccurrences[c - 'A'] += 1;
        }
    }

    private void backtrack() {
        for (int i = 0; i < 26; i++) {
            if (numberOfOccurrences[i] > 0) {
                result++;
                numberOfOccurrences[i]--;
                backtrack();
                numberOfOccurrences[i]++;
            }
        }
    }

}
