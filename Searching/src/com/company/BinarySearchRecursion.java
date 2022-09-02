// Binary Search using Recursion

package com.company;

public class BinarySearchRecursion {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 55, 66, 78};
        int target = 4;
        System.out.println(BS(arr,target, 0, arr.length - 1));
    }
    static int BS(int[] arr, int target, int start, int end) {
        if (start > end) {
            return -1;
        }
        int mid = start + (end - start) / 2;
        if (target == arr[mid]) {
            return mid;
        }
        if (target < arr[mid]) {
            return BS(arr, target, start, mid - 1);
        }
        return BS(arr, target, mid + 1, end);
    }
}
