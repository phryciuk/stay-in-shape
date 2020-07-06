package org.hryciuk.stayinshape.data_structures.trie;

public class TrieNode {
    private TrieNode[] children = new TrieNode[26];
    private char value;
    private boolean isWord;

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

    public boolean isWord() {
        return isWord;
    }

    public void setEndOfWord(boolean word) {
        isWord = word;
    }
}
