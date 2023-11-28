// Implementation of Queue using LinkedList
// Time Complexity of all operations is O(1)

package queueLinkedList;

public class Main {
    public static void main(String[] args) {
        QueueLinkedList queue = new QueueLinkedList();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.dequeue();
        queue.dequeue();
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);
        queue.dequeue();
        System.out.println("Queue Front : " + queue.front.data);
        System.out.println("Queue Rear : " + queue.rear.data);
    }
}

class LinkedListNode {
    int data;
    LinkedListNode next;

    public LinkedListNode (int data) {
        this.data = data;
        next = null;
    }
}

class QueueLinkedList {
    LinkedListNode front, rear;
    int size;

    public QueueLinkedList () {
        front = rear = null;
        size = 0;
    }

    public void enqueue(int num) {
        LinkedListNode temp = new LinkedListNode(num);
        if (rear == null) {
            front = rear = temp;
            return;
        }
        rear.next = temp;
        rear = temp;
        size++;
    }

    public void dequeue() {
        if (front == null) {
            System.out.println("Queue is Empty");
            return;
        }
        front = front.next;
        size--;
        if (front == null) {
            rear = null;
        }
    }
}
