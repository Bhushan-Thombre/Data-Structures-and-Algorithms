// Given weights and values of N items, put these items in a knapsack of capacity W to get the maximum
// total value in the knapsack.

package knapsackProblem;

public class KnapsackProblem {

    // Time Complexity = O(n * W)
    // Space Complexity = O(n * W)
    static int dp(int W, int[] wt, int[] val, int n) {
        int[][] table = new int[n + 1][W + 1];
        for (int i = 0; i <= n; i++) {
            table[i][0] = 0;
        }
        for (int i = 0; i <= W; i++) {
            table[0][i] = 0;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= W; j++) {
                if (wt[i - 1] > j) {
                    table[i][j] = table[i - 1][j];
                }else {
                    table[i][j] = Math.max(val[i - 1] + table[i - 1][j - wt[i - 1]], table[i - 1][j]);
                }
            }
        }
        return table[n][W];
    }

    // Time Complexity = O(2^n)
    // Space Complexity = O(1)
    static int recursion(int W, int[] wt, int[] val, int n) {
        if (n == 0 || W == 0) {
            return 0;
        }
        if (wt[n - 1] > W) {
            return recursion(W, wt, val, n - 1);
        }else {
            return Math.max(recursion(W, wt, val, n - 1), val[n - 1] + recursion(W - wt[n - 1], wt, val, n - 1));
        }
    }
    public static void main(String[] args) {
        int[] val = { 10, 40, 30, 50 };
        int[] wt = { 5, 4, 6, 3 };
        int W = 10;
        int n = 4;
        System.out.println("Using Recursion");
        System.out.println("Maximum Value: " + recursion(W, wt, val, n));
        System.out.println("Using Dynamic Programming");
        System.out.println("Maximum Value: " + dp(W, wt, val, n));
    }
}
