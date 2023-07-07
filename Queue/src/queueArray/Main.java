// Implementation of Queue using Circular Array
// Time Complexity of all operations is O(1)

package queueArray;

public class Main {
    public static void main(String[] args) {
        QueueArray queue = new QueueArray(1000);

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);

        System.out.println(queue.dequeue()
                + " dequeued from queue\n");

        System.out.println("Front item is "
                + queue.front());

        System.out.println("Rear item is "
                + queue.rear());
    }
}

class QueueArray {
    int capacity;
    int size;
    int front;
    int[] arr;

    public QueueArray(int capacity) {
        this.capacity = capacity;
        size = 0;
        front = 0;
        arr = new int[capacity];
    }

    public boolean isFull() {
        return size == capacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getFront() {
        if (isEmpty()) {
            return -1;
        }else {
            return front;
        }
    }

    public int getRear() {
        if (isEmpty()) {
            return - 1;
        }else {
            return (front + size - 1) % capacity;
        }
    }

    public void enqueue(int num) {
        if (isFull()) {
            System.out.println("Queue is full");
            return;
        }
        int rear = getRear();
        rear = (rear + 1) % capacity;
        arr[rear] = num;
        size++;
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return Integer.MIN_VALUE;
        }
        int res = arr[front];
        front = (front + 1) % capacity;
        size--;
        return res;
    }

    public int front() {
        if (isEmpty()) {
            return Integer.MIN_VALUE;
        }
        return arr[front];
    }

    public int rear() {
        if (isEmpty()) {
            return Integer.MIN_VALUE;
        }
        return arr[getRear()];
    }
}
