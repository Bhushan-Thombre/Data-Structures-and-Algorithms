// Brian kerningam's algorithm to find number of set bits
// Time Complexity = O(Number of Set Bits)
package com.company;

public class Optimized {

    static int countSetBits(int n) {
        int count = 0;
        while (n != 0) {
            n = n & (n - 1);
            count++;
        }
        return count;
    }
    public static void main(String[] args) {
        int n = 9;
        int ans = countSetBits(n);
        System.out.println("Number of Set Bits are: " + ans);
    }
}
