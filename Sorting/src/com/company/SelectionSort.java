package com.company;

import java.util.Arrays;

// Selecting the maximum index and swaping it with the last index
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

// Selecting the minimum element and swaping it with the first index
//public class Solution {
//    public void selectionSort(int[] arr) {
//        // Mutates arr so that it is sorted via selecting the minimum element and
//        // swapping it with the corresponding index
//        int min_index;
//        for (int i = 0; i < arr.length; i++) {
//            min_index = i;
//            for (int j = i + 1; j < arr.length; j++) {
//                if (arr[j] < arr[min_index]) {
//                    min_index = j;
//                }
//            }
//            // Swap current index with minimum element in rest of list
//            int temp = arr[min_index];
//            arr[min_index] = arr[i];
//            arr[i] = temp;
//        }
//    }
//}

// Time complexity - O(N * N)
// Best case = O(N * N)
// Worst case = O(N * N)
// Constant Space Complexity
// Selection sort is unstable sorting algorithm
// Selection sort is an in place sorting algorithm