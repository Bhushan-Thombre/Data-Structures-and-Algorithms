// Program to check if the kth bit of a given number is set(1) or not
package com.company;

public class LeftShift {

    static void leftShift(int n, int k) {
        if ((n & (1 << (k - 1))) == 1) {
            System.out.println("Yes");
        }else {
            System.out.println("No");
        }
    }
    public static void main(String[] args) {
        int n = 5;
        int k = 1;
        leftShift(n, k);
    }
}
