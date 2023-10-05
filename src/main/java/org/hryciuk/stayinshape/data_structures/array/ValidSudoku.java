package org.hryciuk.stayinshape.data_structures.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ValidSudoku {

    public boolean isValidSudoku3(char[][] board) {
        int[][] rows = new int[9][9];
        int[][] columns = new int[9][9];
        int[][] boxes = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {

                    // rows
                    if (rows[i][board[i][j] - '1'] != 1) {
                        rows[i][board[i][j] - '1'] = 1;
                    } else {
                        return false;
                    }

                    // columns
                    if (columns[j][board[i][j] - '1'] != 1) {
                        columns[j][board[i][j] - '1'] = 1;
                    } else {
                        return false;
                    }

                    // boxes
                    int boxIndex = (i / 3) * 3 + j / 3;
                    if (boxes[boxIndex][board[i][j] - '1'] != 1) {
                        boxes[boxIndex][board[i][j] - '1'] = 1;
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public boolean isValidSudoku2(char[][] board) {
        Set<String> presence = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    char number = board[i][j];
                    if (!presence.add(number + " in row" + i)
                        || !presence.add(number + " in col" + j)
                            || !presence.add(number + " in box" + i / 3 + j / 3)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    public boolean isValidSudoku(char[][] board) {
        Map<String, Set<Integer>> blocks = new HashMap<>();
        Map<Integer, Set<Integer>> rows = new HashMap<>();
        Map<Integer, Set<Integer>> columns = new HashMap<>();

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] != '.') {
                    int val = Integer.valueOf(board[row][col]);
                    // rows
                    if (rows.get(row) != null) {
                        Set<Integer> rowSet = rows.get(row);
                        if (rowSet.contains(val)) {
                            return false;
                        }
                        rowSet.add(val);
                    } else {
                        Set<Integer> rowSet = new HashSet<>();
                        rowSet.add(val);
                        rows.put(row, rowSet);
                    }

                    // columns
                    if (columns.get(col) != null) {
                        Set<Integer> columnSet = columns.get(col);
                        if (columnSet.contains(val)) {
                            return false;
                        }
                        columnSet.add(val);
                    } else {
                        Set<Integer> columnSet = new HashSet<>();
                        columnSet.add(val);
                        columns.put(col, columnSet);
                    }

                    // boxes
                    String key = "" +  row / 3 + col / 3;
                    if (blocks.get(key) != null) {
                        Set<Integer> blockSet = blocks.get(key);
                        if (blockSet.contains(val)) {
                            return false;
                        }
                        blockSet.add(val);
                    } else {
                        Set<Integer> blockSet = new HashSet<>();
                        blockSet.add(val);
                        blocks.put(key, blockSet);
                    }
                }
            }
        }
        return true;
    }
}
