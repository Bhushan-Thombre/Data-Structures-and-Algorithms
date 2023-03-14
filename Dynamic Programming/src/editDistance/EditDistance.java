// Find the minimum number of operations to convert String 1 to String 2.
// To convert we are allowed to do 3 operations. Either insert or delete or update.
// m = length of String 1
// n = length of String 2

package editDistance;

import java.util.Arrays;

public class EditDistance {

    static int recursive(String str1, String str2, int m, int n) {
        if (m == 0) {
            return n;
        }
        if (n == 0) {
            return m;
        }

        if (str1.charAt(m - 1) == str2.charAt(n - 1)) {
            return recursive(str1, str2, m - 1, n - 1);
        }else {
            return 1 + Math.min(recursive(str1, str2, m, n - 1), Math.min(recursive(str1, str2, m - 1, n), recursive(str1, str2, m - 1, n - 1)));

        }
    }

    static int memo(String str1, String str2, int m, int n) {
        int[][] memo = new int[m + 1][n + 1];
        for (int[] i: memo) {
            Arrays.fill(i, -1);
        }
        if (memo[m][n] != -1) {
            return memo[m][n];
        }
        if (m == 0) {
            memo[m][n] = n;
        }
        if (n == 0) {
            memo[m][n] = m;
        }
        if (str1.charAt(m - 1) == str2.charAt(n - 1)) {
            memo[m][n] = memo(str1, str2, m - 1, n - 1);
        }else {
            memo[m][n] = 1 + Math.min(recursive(str1, str2, m, n - 1), Math.min(recursive(str1, str2, m - 1, n), recursive(str1, str2, m - 1, n - 1)));
        }
        return memo[m][n];
    }

    // Time Complexity = O(m * n)
    // Space Complexity = O(m * n)
    static int table(String str1, String str2, int m, int n) {
        int[][] table = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            table[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            table[0][j] = j;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    table[i][j] = table[i - 1][j - 1];
                }else {
                    table[i][j] = 1 + Math.min(table[i - 1][j], Math.min(table[i][j - 1], table[i - 1][j - 1]));
                }
            }
        }
        return table[m][n];
    }
    public static void main(String[] args) {
        String str1 = "CAT";
        String str2 = "CUT";
        System.out.println("Using Recursion");
        System.out.println("Minimum number of operations to convert " + str1 + " to " + str2 + " is: " + recursive(str1, str2, 3, 3));
        System.out.println("Using Memoization");
        System.out.println("Minimum number of operations to convert " + str1 + " to " + str2 + " is: " + memo(str1, str2, 3, 3));
        System.out.println("Using Tabulation");
        System.out.println("Minimum number of operations to convert " + str1 + " to " + str2 + " is: " + table(str1, str2, 3, 3));
    }
}
