// Given array. Find the number of subsets of the array whose sum is equal to given sum

package subsetSum;

public class SubsetSum {


    // Time Complexity = O(N * Sum)
    // Space Complexity = O(N * Sum)
    static int dp(int[] arr, int sum, int n) {
        int[][] table = new int[n + 1][sum + 1];
        table[0][0] = 1;
        for (int i = 1; i < n + 1; i++) {
            table[i][0] = 1;
        }
        for (int i = 1; i < sum + 1; i++) {
            table[0][i] = 0;
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                if (j < arr[i - 1]) {
                    table[i][j] = table[i - 1][j];
                }else {
                    table[i][j] = table[i - 1][j] + table[i - 1][j - arr[i - 1]];
                }
            }
        }
        return table[n][sum];
    }

    // Time Complexity = O(2 ^ N)
    // Space Complexity = O(1)
    // N = Length of array
    static int recursion(int[] arr, int sum, int n) {
        if (n == 0) {
            if (sum == 0) {
                return 1;
            }
            return 0;
        }
        return recursion(arr, sum, n - 1) + recursion(arr, sum - arr[n - 1], n - 1);
    }
    public static void main(String[] args) {
        int[] arr = { 10, 20, 15 };
        int sum = 25;
        System.out.println("Using Recursion");
        System.out.println("Number of subsets having sum equal to given sum: " + recursion(arr, sum, arr.length));
        System.out.println("Using Dynamic Programming");
        System.out.println("Number of subsets having sum equal to given sum: " + dp(arr, sum, arr.length));
    }
}
