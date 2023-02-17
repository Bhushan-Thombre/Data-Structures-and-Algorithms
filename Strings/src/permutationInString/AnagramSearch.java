// Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.
//In other words, return true if one of s1's permutations is the substring of s2.

package permutationInString;

public class AnagramSearch {


    public static boolean isAnagram(String str, String pat, int i) {
        int[] arr = new int[26];
        for (int j = 0; j < pat.length(); j++) {
            arr[pat.charAt(j) - 'a']++;
            arr[str.charAt(i + j) - 'a']--;
        }
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] != 0) {
                return false;
            }
        }
        return true;
    }
    public static boolean patternSearch(String str, String pat) {
        int n = str.length();
        int m = pat.length();
        for (int i = 0; i <= n - m; i++) {
            if (isAnagram(str, pat, i)) {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        String str = "eidbaooo";
        String pat = "ab";
        System.out.println("Is any permutation of pattern present in the string or not");
        System.out.println("Naive");
        System.out.println(patternSearch(str, pat));
    }
}
