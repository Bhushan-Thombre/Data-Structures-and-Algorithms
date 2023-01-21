package minimumJumpsToReachEnd;

import java.util.Arrays;

public class MinJumps {


    // Time Complexity = O(N * N)
    // Space Complexity = O(N)
    static int dp(int[] arr, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] + j >= i) {
                    if (dp[j] != Integer.MAX_VALUE) {
                        dp[i] = Math.min(dp[i], dp[j] + 1);
                        break;
                    }
                }
            }
        }
        return dp[n - 1];
    }
    static int recursion(int[] arr, int n) {
        if (n == 1) {
            return 0;
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i <= n - 2; i++) {
            if (i + arr[i] >= n - 1) {
                int sub_res = recursion(arr, i + 1);
                if (sub_res != Integer.MAX_VALUE) {
                    res = Math.min(res, sub_res + 1);
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int arr[] = {3, 4, 2, 1, 2, 1};
        int n = 6;
        System.out.println("Using Recursion");
        System.out.println("Minimum Jumps: " + recursion(arr, n));
        System.out.println("Using Dynamic Programming");
        System.out.println("Minimum Jumps: " + dp(arr, n));
    }
}
