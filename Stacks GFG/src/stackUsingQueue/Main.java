// Implement Stack using Queue
// Here push operation is costly and has a time complexity of O(n)
// Other operations has a time complexity of O(1)

package stackUsingQueue;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        StackQueue stack = new StackQueue();
        stack.push(10);
        stack.push(5);
        stack.push(15);
        stack.push(20);

        System.out.println("current size: " + stack.currSize());
        System.out.println(stack.top());
        stack.pop();
        System.out.println(stack.top());
        stack.pop();
        System.out.println(stack.top());

        System.out.println("current size: " + stack.currSize());
    }
}

class StackQueue {
    static Queue<Integer> queue1 = new LinkedList<>();
    static Queue<Integer> queue2 = new LinkedList<>();

    static int size;

    public StackQueue() {
        size = 0;
    }

    public void push(int num) {
        while (!queue1.isEmpty()) {
            queue2.offer(queue1.poll());
        }
        queue1.offer(num);
        while(!queue2.isEmpty()) {
            queue1.offer(queue2.poll());
        }
        size++;
    }

    public int pop() {
        if (queue1.isEmpty()) {
            System.out.println("Stack is Empty");
        }
        size--;
        return queue1.remove();
    }

    public int top() {
        if (queue1.isEmpty()) {
            return -1;
        }
        return queue1.peek();
    }

    public int currSize() {
        return size;
    }
}
