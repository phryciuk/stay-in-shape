package org.hryciuk.stayinshape.box;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a phone pad grid, where you can move a chess piece
 * two boxes up/down and one left/right or two left/right and one up/down, find all the possible 6 digit numbers that result after 6 moves
 */
public class Box3 {

    public Set<Integer> findAllPossibleNumbers() {
        Set<Integer> result = new HashSet<>();
        int[][] phonePad = new int[3][3];

        for (int i = 0; i < 9; ++i) {
            int remainder = i % 3;
            int number = i / 3;
            phonePad[number][remainder] = i + 1;
        }
        boolean[][] visited = new boolean[3][3];
        String number = "";
        dfs(0, 0, number, phonePad, result);
        return result;
    }

    private void dfs(int row, int col, String number, int[][] phonePad, Set<Integer> result) {
        number += "" + phonePad[row][col];
        if (number.length() == 6) {
            result.add(Integer.parseInt(number));
            return;
        }
        // move 2 down and 1 right
        if (row + 2 < phonePad.length && col + 1 < phonePad.length) {
            dfs(row + 2, col + 1, number, phonePad, result);
        }
        // move 2 down and 1 left
        if (row + 2 < phonePad.length && col - 1 >= 0) {
            dfs(row + 2, col - 1, number, phonePad, result);
        }
        // move 2 up and 1 right
        if (row - 2 >= 0 && col + 1 < phonePad.length) {
            dfs(row - 2, col + 1, number, phonePad, result);
        }
        // move 2 up and 1 left
        if (row - 2 >= 0 && col - 1 >= 0) {
            dfs(row - 2, col - 1, number, phonePad, result);
        }
        // move 2 left and 1 up
        if (row - 1 >= 0 && col - 2 >= 0) {
            dfs(row - 1, col - 2, number, phonePad, result);
        }
        // move 2 left and 1 down
        if (row + 1 < phonePad.length && col - 2 >= 0) {
            dfs(row + 1, col - 2, number, phonePad, result);
        }
        // move 2 right and 1 up
        if (row - 1 >= 0 && col + 2 < phonePad.length) {
            dfs(row - 1, col + 2, number, phonePad, result);
        }
        // move 2 right and 1 down
        if (row + 1 < phonePad.length && col + 2 < phonePad.length) {
            dfs(row + 1, col + 2, number, phonePad, result);
        }
    }
}
