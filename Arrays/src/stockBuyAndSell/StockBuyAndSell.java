// The cost of a stock on each day is given in an array.
// Find the maximum profit that you can make by buying and selling on those days.
package stockBuyAndSell;

public class StockBuyAndSell {

    // Time Complexity = O(N)
    // Space Complexity = O(1)
    // N = Length of array
    public static int maxProfitOptimized(int[] arr) {
        int profit = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1]) {
                profit += arr[i] - arr[i - 1];
            }
        }
        return profit;
    }
    public static int maxProfit(int[] arr, int start, int end) {
        if (end <= start) {
            return 0;
        }
        int profit = 0;
        for (int i = start; i < end; i++) {
            for (int j = i + 1; j <= end; j++) {
                if (arr[j] > arr[i]) {
                    int currProfit = arr[j] - arr[i] + maxProfit(arr, start, i - 1) + maxProfit(arr, j + 1, end);
                    profit = Math.max(profit, currProfit);
                }
            }
        }
        return profit;
    }
    public static void main(String[] args) {
        int[] arr = {1, 5, 3, 8, 12};
        System.out.println("Naive");
        System.out.println("Max Profit: " + maxProfit(arr, 0, arr.length - 1));
        System.out.println("Optimized");
        System.out.println("Max Profit: " + maxProfitOptimized(arr));
    }
}
