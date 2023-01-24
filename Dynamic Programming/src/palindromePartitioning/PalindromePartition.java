// Given a string, find the minimum cuts / partition such that each substring is a palindrome

package palindromePartitioning;

public class PalindromePartition {


    static boolean isPalindrome(String str, int startingIndex, int endingIndex) {
        while (startingIndex < endingIndex) {
            if (str.charAt(startingIndex) != str.charAt(endingIndex)) {
                return false;
            }
            startingIndex++;
            endingIndex--;
        }
        return true;
    }

    // Time Complexity = O(N * N * N)
    // Space Complexity = O(N * N)
    // N = Length of the input string
    static int dp(String str, int startingIndex, int endingIndex) {
        int[][] table = new int[str.length()][str.length()];
        for (int i = 0; i < str.length(); i++) {
            table[i][i] = 0;
        }
        for (int gap = 1; gap < str.length(); gap++) {
            for (int i = 0; i + gap < str.length(); i++) {
                int j = i + gap;
                if (isPalindrome(str, i, j)) {
                    table[i][j] = 0;
                }else {
                    table[i][j] = Integer.MAX_VALUE;
                    for (int k = i; k < j; k++) {
                        table[i][j] = Math.min(table[i][j], 1 + table[i][k] + table[k + 1][j]);
                    }
                }
            }
        }

        return table[0][str.length() - 1];
    }
    static int recursion(String str, int startingIndex, int endingIndex) {
        if (isPalindrome(str, startingIndex, endingIndex)) {
            return 0;
        }
        int res = Integer.MAX_VALUE;
        for (int i = startingIndex; i < endingIndex; i++) {
            res = Math.min(res, 1 + recursion(str, startingIndex, i) + recursion(str, i + 1, endingIndex));
        }
        return res;
    }
    public static void main(String[] args) {
        String str = "geek";
        System.out.println("Using Recursion: ");
        System.out.println("Minimum Cuts/Partition: " + recursion(str, 0, 3));
        System.out.println("Using Dynamic Programming: ");
        System.out.println("Minimum Cuts/Partition: " + dp(str, 0, 3));
    }
}
