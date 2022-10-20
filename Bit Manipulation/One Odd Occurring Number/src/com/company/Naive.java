// Given an array of numbers in which every number occurs even number of times, we have to find th number that
// occurs odd number of times in the given array.
// Time Complexity = O(N * N)
package com.company;

public class Naive {

    static void findOdd(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int count = 0;
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] == arr[i]) {
                    count++;
                }
            }
            if (count % 2 != 0) {
                System.out.println(arr[i]);
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = {4, 4, 3, 4 , 4, 5, 5};
        System.out.println("The number that occurs odd number of times is: ");
        findOdd(arr);

    }
}
