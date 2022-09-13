// Print all permutations of the string ABC that do not contain the substring AB
// Naive Approach
// Time Complexity = !n * n
package com.company;

public class Naive {

    static void permute(String str, int l, int r) {
        if (l == r) {
            if (str.contains("AB") == false) {
                System.out.println(str + " ");
            }
            return;
        }else {
            for (int i = l; i <= r; i++) {
                str = new String(swap(str, i, l));
                permute(str, l + 1, r);
                str = new String(swap(str, i, l));
            }
        }
    }

    static char[] swap(String str, int i, int j) {
        char[] ch = str.toCharArray();
        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;
        return ch;
    }
    public static void main(String[] args) {
        String str = "ABC";
        permute(str, 0, str.length() - 1);
    }
}
