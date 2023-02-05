// Given 2 strings, check if the strings are anagrams of each other or not

package anagramChecking;

public class AnagramChecking {

    // Time Complexity = O(N)
    // Space Complexity = O(N)
    public static boolean isAnagram(String str1, String str2) {
        int[] arr = new int[26];
        for (int i = 0; i < str1.length(); i++) {
            arr[str1.charAt(i) - 'a']++;
        }
        for (int i = 0; i < str2.length(); i++) {
            arr[str2.charAt(i) - 'a']--;
        }

        boolean ans = true;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                ans = false;
            }
        }

        return ans;
    }
    public static void main(String[] args) {
        String str1 = "abaac";
        String str2 = "aacba";
        System.out.println("Are the strings anagrams of each other ?");
        System.out.println(isAnagram(str1, str2));
    }
}
