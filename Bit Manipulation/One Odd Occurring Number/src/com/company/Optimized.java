// Properties of XOR operator
// x ^ 0 = 0
// x ^ y = y ^ x
// x ^ (y ^ z) = (x ^ y) ^ z
// x ^ x = 0
// Time complexity = O(N)
package com.company;

public class Optimized {
    static int XOR(int[] arr) {
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            res = res ^ arr[i];
        }
        return res;
    }
    public static void main(String[] args) {
        int[] arr = {4, 4, 3, 4, 4, 5, 5};
        int ans = XOR(arr);
        System.out.println("The number that is present odd number of times is " + ans);
    }
}
