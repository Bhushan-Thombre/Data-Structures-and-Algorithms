// Find the index of the leftmost repeating character in the given string.
// If all the characters are distinct return -1

package leftmostRepeatingCharacter;

import java.util.Arrays;

public class LeftmostRepeatingCharacter {

    // Time Complexity = O(N)
    // Space Complexity = O(N)
    // N = Length of the Input String
    public static int leftMostRepeatingOptimized(String str) {
        int[] arr = new int[26];
        Arrays.fill(arr, -1);
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < str.length(); i++) {
            int index = arr[str.charAt(i) - 'a'];
            if (index == -1) {
                arr[str.charAt(i) - 'a'] = i;
            }else {
                res = Math.min(res, index);
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    // Time Complexity = O(N)
    // Space Complexity = O(N)
    // N = Length of the input string
    public static int leftMostRepeatingBetter(String str) {
        int[] arr = new int[26];
        for (int i = 0; i < str.length(); i++) {
            arr[str.charAt(i) - 'a']++;
        }
        for (int i = 0; i < str.length(); i++) {
            if (arr[str.charAt(i) - 'a'] > 1) {
                return i;
            }
        }
        return -1;
    }

    // Time Complexity = O(N * N)
    // Space Complexity = O(1)
    // N = Length of the string
    public static int leftMostRepeatingNaive(String str) {
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j < str.length(); j++) {
                if (str.charAt(j) == str.charAt(i)) {
                    return i;
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        String str = "abccb";
        System.out.println("Naive");
        System.out.println("Index of leftmost repeating character is: " + leftMostRepeatingNaive(str));
        System.out.println("Better");
        System.out.println("Index of leftmost repeating character is: " + leftMostRepeatingBetter(str));
        System.out.println("Optimized");
        System.out.println("Index of leftmost repeating character is: " + leftMostRepeatingOptimized(str));
    }
}
