package hoffmanCoding;

public class Node {
    char ch;
    int freq;
    Node leftChild;
    Node rightChild;

    public Node(char ch, int freq, Node leftChild, Node rightChild) {
        this.ch = ch;
        this.freq = freq;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }
}
