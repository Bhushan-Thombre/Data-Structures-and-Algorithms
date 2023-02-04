// Move all the 0 elements of array to its end without changing the order of non-zero elements

package moveZerosToEnd;

import java.util.Arrays;

public class MoveZerosToEnd {

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Time Complexity = O(N * N)
    // Space Complexity = O(1)
    // N = Length of the array
    public static void moveZeroNaive(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[j] != 0) {
                        swap(arr, i, j);
                        break;
                    }
                }
            }
        }
    }

    // Time Complexity = O(N)
    // Space Complexity = O(1)
    // N = Length of the array
    public static void moveZeroOptimized(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                swap(arr, i, count);
                count++;
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = {1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0, 9};
//        System.out.println("Naive:");
//        moveZeroNaive(arr);
//        System.out.println(Arrays.toString(arr));
        System.out.println("Optimized:");
        moveZeroOptimized(arr);
        System.out.println(Arrays.toString(arr));
    }
}
