package org.hryciuk.stayinshape.data_structures.array;

import java.util.*;

public class WordSearch2 {
    public List<String> findWords(char[][] board, String[] words) {
        // we add all the words to Trie
        TrieNode trie = new TrieNode();
        for (String w : words) {
            trie.addWord(w);
        }
        Set<String> result = new HashSet<>();
        // initiate a dfs
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[i].length; ++j) {
                dfs(i, j, board, trie, "", result);
            }
        }
        return new ArrayList<>(result);
    }

    private void dfs(int i, int j, char[][] board, TrieNode node, String currentWord, Set<String> result) {
        if (i < 0
                || j < 0
                || i >= board.length
                || j >= board[0].length
                || board[i][j] == '*'
                || !node.children.containsKey(board[i][j])) {
            return;
        }
        char thisOne = board[i][j];
        board[i][j] = '*';
        node = node.children.get(thisOne);
        currentWord += thisOne;
        if (node.isWord) {
            result.add(currentWord);
        }
        dfs(i + 1, j, board, node, currentWord, result);
        dfs(i - 1, j, board, node, currentWord, result);
        dfs(i, j - 1, board, node, currentWord, result);
        dfs(i, j + 1, board, node, currentWord, result);


        board[i][j] = thisOne;
    }
}

class TrieNode {
    boolean isWord;
    Map<Character, TrieNode> children;

    public TrieNode() {
        this.children = new HashMap<>();
    }

    void addWord(String word) {
        TrieNode current = this;
        char[] arr = word.toCharArray();
        for (char c : arr) {
            if (!current.children.containsKey(c)) {
                current.children.put(c, new TrieNode());
            }
            current = current.children.get(c);
        }
        current.isWord = true;
    }
}