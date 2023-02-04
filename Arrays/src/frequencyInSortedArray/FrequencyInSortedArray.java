// Find the frequency of each element in a sorted array

package frequencyInSortedArray;

public class FrequencyInSortedArray {

    // Time Complexity = O(N)
    // Space Complexity = O(1)
    // N = Length of the array
    public static void freq(int[] arr) {
        int freq = 1;
        int i = 1;
        while (i < arr.length) {
            while (i < arr.length && arr[i] == arr[i - 1]) {
                freq++;
                i++;
            }
            System.out.println(arr[i - 1] + " " + freq);
            freq = 1;
            i++;
        }
        if (arr.length == 1 || arr[arr.length - 1] != arr[arr.length - 2]) {
            System.out.println(arr[arr.length - 1] + " " + 1);
        }
    }
    public static void main(String[] args) {
        int[] arr = {10, 10, 20, 30, 30, 30};
        freq(arr);
    }
}
