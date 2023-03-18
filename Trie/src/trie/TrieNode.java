package trie;

public class TrieNode {
    private static final int ALPHABET_SIZE = 26;

    TrieNode[] children = new TrieNode[ALPHABET_SIZE];
    boolean isEndOfWord;

    public TrieNode() {
        isEndOfWord = false;
        for (int i = 0; i < children.length; i++) {
            children[i] = null;
        }
    }

}
