// Given a string. Reverse all the words in the string
// str = My name is Bhushan
// output = Bhushan is name My

package reverseWordsInString;

public class ReverseWordsInString {

    public static void reverse(char[] str, int low, int high) {
        while (low <= high) {
            char temp = str[low];
            str[low] = str[high];
            str[high] = temp;
            low++;
            high--;
        }
    }

    // Time Complexity = O(N)
    // Space Complexity = O(1)
    // N = No. of characters in input string
    public static void reverseWords(char[] str) {
        int start = 0;
        for (int end = 0; end < str.length; end++) {
            if (str[end] == ' ') {
                reverse(str, start, end - 1);
                start = end + 1;
            }
        }
        reverse(str, start, str.length - 1);
        reverse(str, 0, str.length - 1);
    }
    public static void main(String[] args) {
        String string = "My name is Bhushan";
        char[] str = string.toCharArray();
        reverseWords(str);
        System.out.println("Output");
        String output = new String(str);
        System.out.println(output);
    }
}
