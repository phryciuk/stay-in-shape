package org.hryciuk.stayinshape.data_structures.trie;

public class TrieNode {
    public static final int ALPHABET_SIZE = 26;
    private TrieNode[] children = new TrieNode[ALPHABET_SIZE];
    private char value;
    private boolean isEndOfWord;

    public TrieNode() {
    }

    public TrieNode(char c) {
        this.value = c;
    }

    public TrieNode[] getChildren() {
        return children;
    }

    public char getValue() {
        return value;
    }

    public boolean isEndOfWord() {
        return isEndOfWord;
    }

    public void setEndOfWord(boolean word) {
        isEndOfWord = word;
    }
}
