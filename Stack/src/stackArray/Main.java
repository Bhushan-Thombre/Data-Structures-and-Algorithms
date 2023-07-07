// Implementation of Stack using Array
// Time Complexity of all the operations is O(1)

package stackArray;

public class Main {
    public static void main(String[] args) {
        StackArray stack = new StackArray(5);
        stack.push(5);
        stack.push(10);
        stack.push(20);
        System.out.println("Stack");
        stack.printStack();
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println("Size of stack is " + stack.size());
        System.out.println("Is the stack empty? " + stack.isEmpty());
    }
}

class StackArray {
    int capacity;
    int top;
    int[] arr;

    public StackArray(int capacity) {
        this.capacity = capacity;
        top = -1;
        arr = new int[capacity];
    }

    public void push(int num) {
        if (top == capacity - 1) {
            System.out.println("Stack is Full (Overflow)");
            return;
        }
        top++;
        arr[top] = num;
    }

    public int pop() {
        if (top == -1) {
            System.out.println("Stack is Empty (Underflow)");
            return Integer.MIN_VALUE;
        }
        int res = arr[top];
        top--;
        return res;
    }

    public int peek() {
        if (top == -1) {
            System.out.println("Stack is Empty (Underflow)");
            return Integer.MIN_VALUE;
        }
        return arr[top];
    }

    public int size() {
        return top + 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void printStack() {
        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.println("|| " + arr[i] + " ||");
        }
    }
}
