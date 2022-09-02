// Counting sort algorithm on a set of integers from 0 to K (not all values have to be present and some values
// can be duplicated).

// https://leetcode.com/explore/learn/card/sorting/695/non-comparison-based-sorts/4437/

package com.company;

import java.util.Arrays;

public class CountingSort {
    public static void main(String[] args) {
        int[] arr = {5, 4, 5, 5, 1, 1, 3};
        System.out.println(Arrays.toString(countSort(arr)));
    }
    static int[] countSort(int[] arr) {
        int K = Arrays.stream(arr).max().getAsInt();
        int[] counts = new int[K + 1];
        for (int ele: arr) {
            counts[ele] += 1;
        }

        int startingIndex = 0;
        for (int i = 0; i < K + 1; i++) {
            int count = counts[i];
            counts[i] = startingIndex;
            startingIndex += count;
        }

        int[] sortedArray = new int[arr.length];
        for (int elem: arr) {
            sortedArray[counts[elem]] = elem;
            counts[elem] += 1;
        }

        return sortedArray;
    }
}

// Time Complexity = O(N + K)
// Space Complexity = O(N + K)
// Counting Sort is a stable sorting algorithm
