// Find the length of the Longest Increasing Subsequence

package longestIncreasingSubsequence;

public class LIS {

    static int ceilingIndex(int[] tail, int start, int end, int num) {
        while (end > start) {
            int mid = start + (end - start) / 2;
            if (tail[mid] >= num) {
                end = mid;
            }else {
                start = mid + 1;
            }
        }
        return end;
    }

    // Time Complexity = O(N * LogN)
    // Space Complexity = O(N)
    // N = length of Input Array
    static int lisBinarySearch(int[] arr) {
        int[] tail = new int[arr.length];
        tail[0] = arr[0];
        int len = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > tail[len - 1]) {
                tail[len] = arr[i];
                len++;
            }else {
                int index = ceilingIndex(tail, 0, len - 1, arr[i]);
                tail[index] = arr[i];
            }
        }
        return len;
    }

    // Time Complexity = O(n * n)
    // Space Complexity = O(n)
    // n = length of input array
    static int lis(int[] arr) {
        int[] lis = new int[arr.length];
        lis[0] = 1;
        for (int i = 1; i < arr.length; i++) {
            lis[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    lis[i] = Math.max(lis[i], lis[j] + 1);
                }
            }
        }
        int res = lis[0];
        for (int i = 1; i < lis.length; i++) {
            res = Math.max(res, lis[i]);
        }
        return res;
    }
    public static void main(String[] args) {
        int[] arr = {3, 4, 2, 8, 10, 5, 1};
        System.out.println("Using Dynamic Programming");
        System.out.println("Length of Longest Increasing Subsequence is: " + lis(arr));
        System.out.println("Using Binary Search");
        System.out.println("Length of Longest Increasing Subsequence is: " + lisBinarySearch(arr));
    }
}
