// Find the maximum difference of the pair arr[j] and arr[i] such that j > i

package maximumDifference;

public class MaximumDifference {

    // Time Complexity = O(N)
    // Space Complexity = O(1)
    // N = Length of the array
    public static int maxDiffOptimized(int[] arr) {
        int max = arr[1] - arr[0];
        int minVal = arr[0];
        for (int i = 1; i < arr.length; i++) {
            int diff = arr[i] - minVal;
            max = Math.max(max, diff);
            minVal = Math.min(minVal, arr[i]);
        }
        return max;
    }

    // Time Complexity = O(N * N)
    // Space Complexity = O(1)
    // N = Length of the array
    public static int maxDiff(int[] arr) {
        int max = arr[1] - arr[0];
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int diff = arr[j] - arr[i];
                max = Math.max(max, diff);
            }
        }
        return max;
    }
    public static void main(String[] args) {
        int[] arr = {2, 3, 10, 6, 4, 8, 1};
        System.out.println("Naive");
        System.out.println(maxDiff(arr));
        System.out.println("Optimized");
        System.out.println(maxDiffOptimized(arr));
    }
}
