// Given a string str and a pattern string pat
// Find the index of all the occurrences of the pat in str
// N = Length of string str
// M = Length of pattern pat

package patternSearching;

import java.util.ArrayList;
import java.util.List;

public class PatternSearching {

    // Time Complexity = O(N)
    // Space Complexity = O(1)
    // This approach works only if the pattern has distinct characters
    public static List<Integer> distinctOptimized(String str, String pat) {
        List<Integer> list = new ArrayList<>();
        int n = str.length();
        int m = pat.length();
        for (int i = 0; i <= n - m; ) {
            int j;
            for (j = 0; j < m; j++) {
                if (pat.charAt(j) != str.charAt(i + j)) {
                    break;
                }
            }
            if (j == m) {
                list.add(i);
            }
            if (j == 0) {
                i++;
            }else {
                i = i + j;
            }
        }
        return list;
    }

    // Time Complexity = O((N - M + 1) * M)
    // Space Complexity = O(1)
    public static List<Integer> naive(String str, String pat) {
        List<Integer> list = new ArrayList<>();
        int n = str.length();
        int m = pat.length();
        for (int i = 0;  i <= n - m; i++) {
            int j;
            for (j = 0; j < m; j++) {
                if (pat.charAt(j) != str.charAt(i + j)) {
                    break;
                }
            }
            if (j == m) {
                list.add(i);
            }
        }
        return list;
    }
    public static void main(String[] args) {
        String str = "ABCABCD";
        String pat = "ABCD";
        System.out.println("Naive");
        System.out.println(naive(str, pat));
        System.out.println("Distinct Optimized");
        System.out.println(distinctOptimized(str, pat));
    }
}
