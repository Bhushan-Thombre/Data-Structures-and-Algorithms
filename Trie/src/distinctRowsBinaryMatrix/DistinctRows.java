// Find the count of distinct rows in a binary matrix

package distinctRowsBinaryMatrix;

public class DistinctRows {

    static final int M = 4;
    static final int N = 3;

    static int mat[][] = {{1, 0, 0},
            {1, 1, 1},
            {1, 0, 0},
            {0, 1, 0}};

    static class Trie {
        Trie[] children = new Trie[2];
    }
    static Trie root;

    // Time Complexity = O(M * N)
    // Space Complexity = O(M * N)
    public static int countDistinct() {
        Trie root = new Trie();
        int res = 0;
        for (int row = 0; row < M; row++) {
            if (insert(root, row)) {
                res++;
            }
        }
        return res;
    }

    public static boolean insert(Trie root, int row) {
        Trie curr = root;
        boolean flag = false;
        for (int i = 0; i < N; i++) {
            int index = mat[row][i];
            if (curr.children[index] == null) {
                curr.children[index] = new Trie();
                flag = true;
            }
            curr = curr.children[index];
        }
        return flag;
    }

    public static void main(String[] args) {
        System.out.println("Number of distinct rows in the binary matrix: ");
        System.out.println(countDistinct());
    }
}
