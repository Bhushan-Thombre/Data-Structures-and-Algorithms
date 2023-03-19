// Hoffman Coding.
// Hoffman Coding is a lossless compression technique. It is a variable length encoding technique.
// It is based on 2 principles.
// 1) The character with the highest frequency has the smallest variable length code and the character with the lowest
//      frequency has the largest variable length code.
// 2) The codes are prefix free, i.e., the code for 1 character cannot be the prefix code for another character.


// Time Complexity = O(N * LogN)
// Space Complexity = O(N)

package hoffmanCoding;

import java.util.PriorityQueue;

public class HoffmanCoding {

    public static void printCode(Node root, String str) {
        if (root == null) {
            return;
        }
        if (root.ch != '$') {
            System.out.print(root.ch + "->>" + str);
            System.out.println();
            return;
        }
        printCode(root.leftChild, str + "0");
        printCode(root.rightChild, str + "1");
    }

    public static void generateTree(char[] arr, int[] freq) {
        PriorityQueue<Node> priorityQueue = new PriorityQueue<Node>((n1, n2) -> n1.freq - n2.freq);
        for (int i = 0; i < arr.length; i++) {
            priorityQueue.add(new Node(arr[i], freq[i], null, null));
        }
        while (priorityQueue.size() > 1) {
            Node left = priorityQueue.poll();
            Node right = priorityQueue.poll();
            priorityQueue.add(new Node('$', left.freq + right.freq, left, right));
        }
        printCode(priorityQueue.peek(), "");
    }
    public static void main(String[] args) {
        char[] arr = {'a', 'd', 'e', 'f'};
        int[] freq = {30, 40, 80, 60};

        System.out.println("The hoffman codes are: ");
        generateTree(arr, freq);
    }
}
