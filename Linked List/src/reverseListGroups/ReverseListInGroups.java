// Reverse LinkedList in Groups of K

package reverseListGroups;

class Node {
    int val;
    Node next;

    public Node() {

    }

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, Node next) {
        this.val = val;
        this.next = next;
    }
}

public class ReverseListInGroups {

    // Time Complexity = O(N)
    // Space Complexity = O(N / k)
    public static Node reverseInGroupsRecursive(Node head, int k) {
        Node prev = null;
        Node curr = head;
        Node Next = null;

        int count = 0;

        while (curr != null && count < k) {
            Next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = Next;
            count++;
        }

        if (Next != null) {
            Node rest_head = reverseInGroupsRecursive(Next, k);
            head.next = rest_head;
        }

        return prev;
    }


    public static Node reverseInGroupIterative(Node head, int k) {
        Node curr = head;
        Node prevFirst = null;
        boolean isFirstPass = true;

        while (curr != null) {
            Node first = curr;
            Node prev = null;
            int count = 0;
            while (curr != null && count < k) {
                Node Next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = Next;
                count++;
            }
            if (isFirstPass) {
                head = prev;
                isFirstPass = false;
            }else {
                prevFirst.next = prev;
            }
            prevFirst = first;
        }

        return head;
    }

    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Node head=new Node(1);
        head.next=new Node(2);
        head.next.next=new Node(3);
        head.next.next.next=new Node(4);
        head.next.next.next.next=new Node(5);
//        System.out.println("Recursive");
//        printList(head);
//        head = reverseInGroupsRecursive(head, 3);
//        printList(head);
        System.out.println("Iterative");
        printList(head);
        head = reverseInGroupIterative(head, 3);
        printList(head);
    }
}
