package org.hryciuk.stayinshape.data_structures.array;

/**
 * https://leetcode.com/problems/word-search/
 */
public class WordSearch {
    public boolean exist(char[][] board, String word) {
        if (word == null || word.length() == 0) {
            return false;
        }
        int totalSize = board.length * board[0].length;
        if (word.length() > totalSize) {
            return false;
        }
        char[] wordArr = word.toCharArray();
        char currentChar = wordArr[0];
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[i].length; ++j) {
                if (board[i][j] == currentChar) {
                    boolean result = helper(board, i, j, 0, wordArr);
                    if (result) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean helper(char[][] board, int i, int j, int index, char[] word) {
        if (i >= 0 && i < board.length && j >= 0 && j < board[0].length && index < word.length && index >= 0 && word[index] == board[i][j]) {
            if (index == word.length - 1) {
                return true;
            }
            board[i][j] = '*';
            boolean result = helper(board, i, j + 1, index + 1, word)
                    || helper(board, i, j - 1, index + 1, word)
                    || helper(board, i - 1, j, index + 1, word)
                    || helper(board, i + 1, j, index + 1, word);
            if (result) {
                return true;
            } else {
                board[i][j] = word[index];
                return false;
            }
        } else {
            return false;
        }
    }
}
