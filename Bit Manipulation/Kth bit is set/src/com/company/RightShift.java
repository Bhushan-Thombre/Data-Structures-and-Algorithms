// Program to check if the kth bit of a given number is set(1) or not
package com.company;

public class RightShift {
    static void rightShift(int n, int k) {
        if (((n >> (k - 1)) & 1) == 1) {
            System.out.println("Yes");
        }else {
            System.out.println("No");
        }
    }
    public static void main(String[] args) {
        int n = 5;
        int k = 1;
        rightShift(n, k);
    }
}
