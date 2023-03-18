// Trie = Prefix Tree

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
    public static void main(String[] args) {
        Trie node = new Trie();

        String[] keys = {"bad", "bat", "geek", "geeks", "cat", "cut"};

        for (int i = 0; i < keys.length; i++) {
            insert(keys[i]);
        }

        // Normal Search
        System.out.println("Is 'geeks' present: ");
        System.out.println(search("geeks"));

        //Prefix Search
        System.out.println("Is 'geek' present: ");
        System.out.println(prefixSearch("geek"));

        System.out.println("Is 'bhushan' present: ");
        System.out.println(search("bhushan"));



    }
}
