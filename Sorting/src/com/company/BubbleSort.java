package com.company;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] nums = {5, 4, 3, 2, 1};
        bubbleSort(nums);
        System.out.println(Arrays.toString(nums));
    }
    static void bubbleSort(int[] arr) {
        boolean hasSwapped = true;
        while (hasSwapped) {
            hasSwapped = false;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    // Swap adjacent elements
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    hasSwapped = true;
                }
            }
        }
    }
}

// Time complexity = O(N * N)
// Best case = O(N)
// Worst case = O(N * N)
// Constant space complexity
// Bubble sort is a stable sorting algorithm