// Coin Change Problem
// Given certain amount and an array containing coins, find the minimum no. of coins to get the amount.
// The coins are in Indian currency. Eg. 10, 5, 2, 1.
// If the coins have any random value, then greedy approach will not work in that case.

package coinChangeProblem;

import java.util.Arrays;

public class CoinChangeProblem {

    // Time Complexity = O(N)
    // Space Complexity = O(1)
    public static int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int res = 0;
        for (int i = coins.length - 1; i >= 0; i--) {
            if (coins[i] <= amount) {
                int c = (int)Math.floor(amount / coins[i]);
                res += c;
                amount -= coins[i] * c;
            }
            if (amount == 0) {
                break;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int[] coins = {5, 10, 2, 1};
        int amount = 57;

        int ans = coinChange(coins, amount);
        System.out.println("The minimum number of coins required is: ");
        System.out.println(ans);
    }
}
