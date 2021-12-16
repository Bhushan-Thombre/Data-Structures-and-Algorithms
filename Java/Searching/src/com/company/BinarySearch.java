package com.company;

public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = {-18, -2, 0, 3, 5, 14, 18, 22};
        int a = 14;
        int ans = binarySearch(nums, a);
        System.out.println("The number is at index " + ans);
    }
    static int binarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target < arr[mid]) {
                end = mid - 1;
            }else if (target > arr[mid]) {
                start = mid + 1;
            }else {
                return mid;
            }
        }
        return -1;
    }
}