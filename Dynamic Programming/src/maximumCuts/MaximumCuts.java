// Given a rod of length n and 3 integers a, b and c
// Find the maximum cuts in which the rod can be divided such that the length of each cut is either a, b or c
// If it is not possible to make the cuts return -1

package maximumCuts;

public class MaximumCuts {

    // Time Complexity = O(n)
    // Space Complexity = O(n)
    static int dp(int length, int a, int b, int c) {
        int[] table = new int[length + 1];
        table[0] = 0;
        for (int i = 1; i <= length; i++) {
            table[i] = -1;
            if (i - a >= 0) {
                table[i] = Math.max(table[i], table[i - a]);
            }
            if (i - b >= 0) {
                table[i] = Math.max(table[i], table[i - b]);
            }
            if (i - c >= 0) {
                table[i] = Math.max(table[i], table[i - c]);
            }
            if(table[i] != -1) {
                table[i]++;
            }
        }
        return table[length];
    }

    // Time Complexity = O(3 ^ n)
    // Space Complexity = O(1)
    // n = length
    static int recursion(int length, int a, int b, int c) {
        if (length < 0) {
            return -1;
        }
        if (length == 0) {
            return 0;
        }
        int res = Math.max(recursion(length - a, a, b, c), Math.max(recursion(length - b, a, b, c), recursion(length - c, a, b, c)));
        if (res < 0) {
            return -1;
        }
        return res + 1;
    }
    public static void main(String[] args) {
        int length = 5;
        int a = 1;
        int b = 2;
        int c = 3;
        System.out.println("Maximum Cuts using Recursion: " + recursion(length, a, b, c));
        System.out.println("Maximum Cuts using Dynamic Programming Tabulation Approach: " + dp(length, a, b, c));
    }
}
