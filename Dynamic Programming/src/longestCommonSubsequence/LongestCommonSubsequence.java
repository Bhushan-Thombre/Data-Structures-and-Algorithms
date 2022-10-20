// Find the length of longest common subsequence in the given two strings
// Using recursion time complexity is exponential, i.e, O(2 ^ n)
// Using memoization approach of dynamic programming, time complexity is O(m * n)
// m = length of first string
// n = length of second string

package longestCommonSubsequence;

import java.util.Arrays;
import java.util.Scanner;

public class LongestCommonSubsequence {
    static int lcs(String s1, String s2, int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }
        if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
            return 1 + lcs(s1, s2, m - 1, n - 1);
        }
        return Math.max(lcs(s1, s2, m - 1, n), lcs(s1, s2, m, n - 1));
    }

    static int lcsMemo(String s1, String s2, int m, int n) {
        int[][] memo = new int[m + 1][n + 1];
        for (int[] i: memo) {
            Arrays.fill(i, -1);
        }
        if (memo[m][n] != -1) {
            return memo[m][n];
        }
        if (m == 0 || n == 0) {
            memo[m][n] = 0;
        }
        if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
            memo[m][n] = 1 + lcs(s1, s2, m - 1, n - 1);
        }else {
            memo[m][n] = Math.max(lcs(s1, s2, m - 1, n), lcs(s1, s2, m, n - 1));
        }
        return memo[m][n];
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Input First String: ");
        String s1 = input.next();
        System.out.println("Input Second String: ");
        String s2 = input.next();
        System.out.println("The length of longest common subsequence using recursion is: ");
        System.out.println(lcs(s1, s2, s1.length(), s2.length()));
        System.out.println("The length of longest common subsequence using memoization is: ");
        System.out.println(lcsMemo(s1, s2, s1.length(), s2.length()));
    }
}
