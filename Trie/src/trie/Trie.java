// Trie = Prefix Tree
// Trie data structure also known as Prefix Tree is used to implement dictionary and provides better time complexity
// for search, insert and delete operation as compared to Hash Map.
// Time complexity for search, insert and delete using Hash Map is O(N) on average, it can be worst.
// Time complexity for search, insert and delete using Trie is O(N) in worst case.
// Also Hashmap does not support operations like prefix search which are supported by Trie data structure.

package trie;

public class Trie {

    static TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Time Complexity = O(N)
    // Space Complexity = O(N)
    public static void insert(String key) {
        int level;
        int length = key.length();
        int index;

        TrieNode curr = root;

        for (level = 0; level < length; level++) {
            index = key.charAt(level) - 'a';
            if (curr.children[index] == null) {
                curr.children[index] = new TrieNode();
            }
            curr = curr.children[index];
        }

        curr.isEndOfWord = true;
    }

    // Time Complexity = O(N)
    // Space Complexity = O(N)
    public static boolean search(String key) {
        int level;
        int length = key.length();
        int index;

        TrieNode curr = root;

        for (level = 0; level < length; level++) {
            index = key.charAt(level) - 'a';
            if (curr.children[index] == null) {
                return false;
            }
            curr = curr.children[index];
        }

        return (curr != null && curr.isEndOfWord);
    }

    // Time Complexity = O(N)
    // Space Complexity = O(N)
    public static boolean prefixSearch(String prefix) {
        int level;
        int length = prefix.length();
        int index;

        TrieNode curr = root;

        for (level = 0; level < length; level++) {
            index = prefix.charAt(level) - 'a';
            if (curr.children[index] == null) {
                return false;
            }
            curr = curr.children[index];
        }

        return true;
    }

    public static boolean isEmpty(TrieNode root) {
        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null) {
                return false;
            }
        }
        return true;
    }

    // Time Complexity = O(N)
    public static TrieNode delete(TrieNode root, String key, int i) {
        if (root == null) {
            return null;
        }

        if (i == key.length()) {
            if (root.isEndOfWord) {
                root.isEndOfWord = false;
            }
            if (isEmpty(root)) {
                root = null;
            }
            return root;
        }

        int index = key.charAt(i) - 'a';
        root.children[index] = delete(root, key, i + 1);

        if (isEmpty(root) && !root.isEndOfWord) {
            root = null;
        }

        return root;
    }
    public static void main(String[] args) {
        Trie node = new Trie();

        String[] keys = {"an", "and", "ant", "bad", "bat", "zoo"};

        for (int i = 0; i < keys.length; i++) {
            insert(keys[i]);
        }

        // Normal Search
        System.out.println("Is 'and' present: ");
        System.out.println(search("and"));

        //Prefix Search
        System.out.println("Is 'zoo' present: ");
        System.out.println(prefixSearch("zoo"));

        root = delete(root, "zoo", 0);

        // After deletion
        System.out.println("Is 'zoo' present: ");
        System.out.println(search("zoo"));


    }
}
