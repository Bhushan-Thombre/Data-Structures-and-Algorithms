// Implementation of Stack using ArrayList
// Time complexity of all operations is O(1)

package stackArrayList;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        StackArrayList stack = new StackArrayList();
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

class StackArrayList {
    ArrayList<Integer> list = new ArrayList<>();

    public void push(int num) {
        list.add(num);
    }

    public int pop() {
        if (list.size() == 0) {
            System.out.println("Stack is Empty (Underflow)");
        }
        int res = list.get(list.size() - 1);
        list.remove(list.size() - 1);
        return res;
    }

    public int peek() {
        if (list.size() == 0) {
            System.out.println("Stack is Empty (Underflow)");
        }
        return list.get(list.size() - 1);
    }

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void printStack() {
        for (int i = list.size() - 1; i >= 0; i--) {
            System.out.println("|| " + list.get(i) + " ||");
        }
    }
}
