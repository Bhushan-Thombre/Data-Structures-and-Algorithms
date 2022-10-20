package com.company;

public class Naive {

    static boolean power(int n) {
        if (n == 0) {
            return false;
        }
        while ( n != 1) {
            if (n % 2 != 0) {
                return false;
            }
            n = n / 2;
        }
        return true;
    }
    public static void main(String[] args) {
        int n = 16;
        System.out.println("Is the given number a power of 2? " + power(n));
    }
}
