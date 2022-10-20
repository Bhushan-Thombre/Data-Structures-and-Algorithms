// Find the nth Fibonacci number using recursion and dynamic programming
// Using recursion the time complexity is exponential, i.e, O(2 ^ n)
// Using memoization approach of dynamic programming, i.e, top-down approach the time complexity is linear, i.e, O(n)
// Using tabulation approach of dynamic programming, i.e, bottom-up approach the time complexity is linear, i.e, O(n)
package fibonacciSeries;

import java.util.Arrays;
import java.util.Scanner;

public class Fibonacci {

    static int fibonacciRecursive(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    static int fibonacciMemo(int n) {
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        if (memo[n] == -1) {
            int res;
            if (n == 0 || n == 1) {
                res = n;
            }else {
                res = fibonacciMemo(n - 1) + fibonacciMemo(n - 2);
            }
            memo[n] = res;
        }
        return memo[n];
    }

    static int fibonacciTable(int n) {
        int[] f = new int[n + 1];
        f[0] = 0;
        f[1] = 1;
        for (int i = 2; i <= n; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f[n];
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int n = input.nextInt();
        System.out.println("The " + n + " fibonacci number using recursion is: ");
        System.out.println(fibonacciRecursive(n));
        System.out.println("The " + n + " fibonacci number using memoization is: ");
        System.out.println(fibonacciMemo(n));
        System.out.println("The " + n + " fibonacci number using tabulation is: ");
        System.out.println(fibonacciTable(n));
    }
}
