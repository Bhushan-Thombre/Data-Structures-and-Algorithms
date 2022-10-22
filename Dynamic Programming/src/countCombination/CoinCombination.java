// Given an array and a number "sum". Find the number of possible combinations of all the elements of the array
// whose addition is equal to sum.
package countCombination;

import java.util.Arrays;
import java.util.Scanner;

public class CoinCombination {

    static int combination(int[] arr, int n, int sum) {
        if (sum == 0) {
            return 1;
        }
        if (n == 0) {
            return 0;
        }
        int res = combination(arr, n - 1, sum);
        if (arr[n - 1] <= sum) {
            res += combination(arr, n, sum - arr[n - 1]);
        }
        return res;
    }

    // Time Complexity = O(sum * n)
    // Space Complexity = O(sum * n)
    static int combinationDp(int[] arr, int n, int sum) {
        int[][] table = new int[sum + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            table[0][i] = 1;
        }
        for (int i = 0; i <= sum; i++) {
            table[i][0] = 0;
        }
        for (int i = 1; i <= sum; i++) {
            for (int j = 1; j <= n; j++) {
                table[i][j] = table[i][j - 1];
                if (arr[j - 1] <= i) {
                    table[i][j] += table[i - arr[j - 1]][j];
                }
            }
        }
        return table[sum][n];
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter number of elements in array: ");
        int n = input.nextInt();
        System.out.println("Enter the array elements: ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = input.nextInt();
        }
        System.out.println("The array is: " + Arrays.toString(arr));
        System.out.println("Enter the sum value: ");
        int sum = input.nextInt();
        System.out.println("The number of combinations in the given array that add to " + sum + " is: ");
        System.out.println(combination(arr, n, sum));
        System.out.println("The number of combinations in the given array that add to " + sum + " using DP is: ");
        System.out.println(combinationDp(arr, n, sum));
    }
}
