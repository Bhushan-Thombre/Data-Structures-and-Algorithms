// Generally, on almost sorted arrays where the number of inversions is relatively small compared to the
// size of the array, insertion sort will be quite fast since the number of swaps required will be low on
// almost sorted arrays.

// Next, insertion sort can also be the best choice on small arrays.
// This is more of an empirical observation based on experiments, but it is one that you should be aware of.
// Many sorting functions have a quick check for the size of the collection and if that value is below a threshold,
// the program will default to insertion sort.
// Java's official implementation of Arrays.sort() performs such a check before performing more theoretically optimal
// sorts.

// In terms of disadvantages, on larger collections with many inversions, other sorts will generally outperform
// insertion sort. However, of all the sorts we have covered thus far, insertion sort is the first that is
// practically used, depending on the context.

package com.company;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    static void insertionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    swap(arr, j, j - 1);
                }else {
                    break;
                }
            }
        }
    }
    static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}

// Leetcode code
//public class Solution {
//    public void insertionSort(int[] arr) {
//        // Mutates elements in arr by inserting out of place elements into appropriate
//        // index repeatedly until arr is sorted
//        for (int i = 1; i < arr.length; i++) {
//            int currentIndex = i;
//            while (currentIndex > 0 && arr[currentIndex - 1] > arr[currentIndex]) {
//                // Swap elements that are out of order
//                int temp = arr[currentIndex];
//                arr[currentIndex] = arr[currentIndex - 1];
//                arr[currentIndex - 1] = temp;
//                currentIndex -= 1;
//            }
//        }
//    }
//}

// Time complexity = O(N * N)
// Best case = O(N)
// Worst case = O(N * N)
// Insertion sort is a stable sorting algorithm