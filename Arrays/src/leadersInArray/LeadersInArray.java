// Find all the leaders in the given array.
// An array element is said to be leader if it is strictly greater than all the elements to the right of it
// in the array.

package leadersInArray;

import java.util.ArrayList;
import java.util.List;

public class LeadersInArray {

    // Time Complexity = O(N)
    // Space Complexity = O(1)
    // N = Length of the array
    public static void leadersOptimized(int[] arr) {
        int currLeader = arr[arr.length - 1];
        System.out.print(currLeader + " ");
        for (int i = arr.length - 2; i >= 0; i--) {
            if (currLeader < arr[i]) {
                currLeader = arr[i];
                System.out.print(currLeader + " ");
            }
        }
    }

    // Time Complexity = O(N * N)
    // Space Complexity = O(1)
    // N = Length of the array
    public static List<Integer> leadersNaive(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            boolean flag = false;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] <= arr[j]) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                list.add(arr[i]);
            }
        }
        return list;
    }
    public static void main(String[] args) {
        int[] arr = {7, 10, 4, 10, 6, 5, 2};
        System.out.println("Naive");
        System.out.println(leadersNaive(arr));
        System.out.println("Optimized");
        leadersOptimized(arr);
    }
}
