// Program to count the number of set bits(1) in the binary representation of given number
// Time complexity = O(Total number of bits in n)
package com.company;

public class Naive {

    static int countSet(int n) {
        int count = 0;
        while (n != 0) {
            if ((n & 1) == 1) {
                count++;
            }
            n = n >> 1;
        }
        return count;
    }
    public static void main(String[] args) {
        int n = 9;
        int ans = countSet(n);
        System.out.println("The number of set bits are: " + ans);
    }
}
