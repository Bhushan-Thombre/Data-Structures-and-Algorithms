// Efficient Solution
package com.company;

public class Optimized {
    static boolean power2(int n) {
        return (n != 0) && ((n & (n - 1)) == 0);
    }
    public static void main(String[] args) {
        int n = 16;
        System.out.println("Is the given number a power of 2? " + power2(n));
    }
}

