// Array Rotation

package rotateArrayDplaces;

import java.util.Arrays;

public class RotateArrayDPlaces {


    public static void reverse(int[] arr, int low, int high) {
        while (low < high) {
            int temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;
            low++;
            high--;
        }
    }

    // Time Complexity = O(N)
    // Space Complexity = O(1)
    // N = Length of array
    public static void leftRotateOptimized(int[] arr, int d) {
        reverse(arr, 0, d - 1);
        reverse(arr, d, arr.length - 1);
        reverse(arr, 0, arr.length - 1);
    }

    // Time Complexity = O(D * N);
    // Space Complexity = O(1)
    // N = Length of Array
    public static void leftRotateNaive(int[] arr, int d) {
        for (int i = 0; i < d; i++) {
            int temp = arr[0];
            for (int j = 1; j < arr.length; j++) {
                arr[j - 1] = arr[j];
            }
            arr[arr.length - 1] = temp;
        }
    }

    // Time Complexity = O(D * N);
    // Space Complexity = O(1)
    // N = Length of Array
    public static void rightRotateNaive(int[] arr, int d) {
        for (int i = 0; i < d; i++) {
            int temp = arr[arr.length - 1];
            for (int j = arr.length - 1; j > 0; j--) {
                arr[j] = arr[j - 1];
            }
            arr[0] = temp;
        }
    }

    // Time Complexity = O(N)
    // Space Complexity = O(1)
    // N = Length of array
    public static void rightRotateOptimized(int[] arr, int d) {
        reverse(arr, arr.length - d, arr.length - 1);
        reverse(arr, 0, d);
        reverse(arr, 0, arr.length - 1);
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int d = 2;
//        System.out.println("Left Rotate the Array by D places Naive:");
//        leftRotateNaive(arr, d);
//        System.out.println(Arrays.toString(arr));
//        System.out.println("Left Rotate the Array by D places Optimized:");
//        leftRotateOptimized(arr, d);
//        System.out.println(Arrays.toString(arr));
//        System.out.println("Right Rotate the Array by D places Naive:");
//        rightRotateNaive(arr, d);
//        System.out.println(Arrays.toString(arr));
        System.out.println("Right rotate the array by D places Optimized:");
        rightRotateOptimized(arr, d);
        System.out.println(Arrays.toString(arr));
    }
}
