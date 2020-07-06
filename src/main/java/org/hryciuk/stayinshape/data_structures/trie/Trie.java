package org.hryciuk.stayinshape.data_structures.trie;

public class Trie {

    private TrieNode root;

    public Trie() {
        this.root = new TrieNode('_');
    }

    // O(n)
    public void insert(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); ++i) {
            char currentChar = word.charAt(i);
            if (current.getChildren()[currentChar - 'a'] == null) {
                current.getChildren()[currentChar - 'a'] = new TrieNode(currentChar);
            }
            current = current.getChildren()[currentChar - 'a'];
        }
        current.setEndOfWord(true);
    }

    public boolean find(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); ++i) {
            char currentChar = word.charAt(i);
            if (current.getChildren()[currentChar - 'a'] == null) {
                return false;
            }
            current = current.getChildren()[currentChar - 'a'];
        }
        return current.isWord();
    }

    private Trie createExampleTrie() {
        Trie trie = new Trie();

        trie.insert("Programming");
        trie.insert("is");
        trie.insert("a");
        trie.insert("way");
        trie.insert("of");
        trie.insert("life");

        return trie;
    }

}
