package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class LinearSearch {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter an array of integers: ");
        int[] nums = new int[6];
        for (int j = 0; j < nums.length; j++) {
            nums[j] = input.nextInt();
        }
        System.out.println("The array of integers is: " + Arrays.toString(nums));
        System.out.println("Enter the target integer: ");
        int target = input.nextInt();
        int ans = linearsearch(nums, target);
        System.out.println("The index at which a given number is present is: " + ans);
    }

    static int linearsearch(int[] arr, int target) {
        if (arr.length == 0) {
            return -1;
        }
        for (int i = 0; i < arr.length; i++) {
            int element = arr[i];
            if (element == target) {
                return i;
            }
        }
        return -1;
    }
}

// Time complexity
// Best case = O(1)
// Worst case = O(N)