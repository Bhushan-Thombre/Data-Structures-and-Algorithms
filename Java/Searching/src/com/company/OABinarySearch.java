//Order Agnostic Binary Search

package com.company;

public class OABinarySearch {
    public static void main(String[] args) {
        int[] nums = {95, 84, 70, 52, 26, 16, 3, -4};
        int a = 70;
        int ans = orderAgnosticBS(nums, a);
        System.out.println("The index of the given number is " + ans);
    }
    static int orderAgnosticBS(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        boolean isAsc = arr[start] < arr[end];

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target == arr[mid]) {
                return mid;
            }
            if (isAsc) {
                if (target < arr[mid]) {
                    end = mid - 1;
                }else {
                    start = mid + 1;
                }
            }else {
                if (target < arr[mid]) {
                    start = mid + 1;
                }else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
}

// Time complexity
// Best case = O(1)
// Worst case = O(logN)