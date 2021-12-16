package com.company;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] nums = {5, 4, 3, 2, 1};
        selectionSort(nums);
        System.out.println(Arrays.toString(nums));
    }
    static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int last = arr.length - i - 1;
            int maxindex = getMaxIndex(arr, 0, last);
            swap(arr, maxindex, last);
        }
    }
    static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
    static int getMaxIndex(int[] arr, int start, int end) {
        int max = start;
        for (int j = start; j <= end; j++) {
            if (arr[max] < arr[j]) {
                max = j;
            }
        }
        return max;
    }
}

// Time complexity
// Best case = O(N * N)
// Worst case = O(N * N)
// Selection sort is a unstable sorting algorithm