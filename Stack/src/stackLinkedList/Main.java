// Implementation of stack using LinkedList
// Time Complexity of all operations is O(1)

package stackLinkedList;

public class Main {
    public static void main(String[] args) {
        StackLinkedList stack = new StackLinkedList();
        stack.push(5);
        stack.push(10);
        stack.push(20);
        System.out.println("Stack");
        stack.printStack();
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println("Size " + stack.size());
        System.out.println("Is stack empty? " + stack.isEmpty());
    }
}

class LinkedListNode {
    int data;
    LinkedListNode next;

    public LinkedListNode(int data) {
        this.data = data;
        next = null;
    }
}

class StackLinkedList {
    LinkedListNode head;
    int size;

    public StackLinkedList() {
        head = null;
        size = 0;
    }

    public void push(int num) {
        LinkedListNode temp = new LinkedListNode(num);
        temp.next = head;
        head = temp;
        size++;
    }

    public int pop() {
        if (size == 0) {
            System.out.println("Stack is Empty (Underflow)");
            return Integer.MIN_VALUE;
        }
        int res = head.data;
        head = head.next;
        size--;
        return res;
    }

    public int peek() {
        if (size == 0) {
            System.out.println("Stack is Empty (Underflow)");
            return Integer.MIN_VALUE;
        }
        return head.data;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void printStack() {
        LinkedListNode temp = head;
        while (temp != null) {
            System.out.println("|| " + temp.data + " ||");
            temp = temp.next;
        }
    }
}
