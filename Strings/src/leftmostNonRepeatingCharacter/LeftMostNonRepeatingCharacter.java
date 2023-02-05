// Find the index of the leftmost non-repeating character in the input string
// If all characters repeat return -1
package leftmostNonRepeatingCharacter;

public class LeftMostNonRepeatingCharacter {

    // Time Complexity = O(N)
    // Space Complexity = O(N)
    // N = Length of the input string
    public static int leftMostRepeating(String str) {
        int[] arr = new int[26];
        for (int i = 0; i < str.length(); i++) {
            arr[str.charAt(i) - 'a']++;
        }
        for (int i = 0; i < str.length(); i++) {
            if (arr[str.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        String str = "apple";
        System.out.println("Index of the leftmost non repeating character: " + leftMostRepeating(str));
    }
}
