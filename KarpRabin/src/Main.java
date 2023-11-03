// String searching
// Find the first index of occurrence of pattern string in text string.
// If pattern is not present in text, return -1

// Karp-Rabin Algorithm
// Time Complexity = O(pattern.length() + text.length() * cost of hash algo)

public class Main {
    public static void main(String[] args) {
        KarpRabin instance = new KarpRabin();
        String pattern = "Sanjay";
        String text = "Bhushan Sanjay Thombre";
        int index = instance.search(pattern, text);
        System.out.println("The first index of occurrence of pattern in text is " + index);
    }
}