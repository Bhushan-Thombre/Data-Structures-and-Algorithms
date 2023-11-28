public class CircularQueue {
    protected int[] data;
    private static final int DEFAULT_SIZE = 10;
    protected int front = 0;
    protected int end = 0;
    private int size = 0;
    public CircularQueue() {
        this(DEFAULT_SIZE);
    }
    public CircularQueue(int size) {
        this.data = new int[size];
    }
    public boolean isFull() {
        return size == data.length;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public boolean insert(int item) {
        if (isFull()) {
            System.out.println("Cannot insert item. Queue full!!");
            return false;
        }
        data[end] = item;
        end = (end + 1) % data.length;
        size++;
        return true;
    }
    public int remove() throws Exception {
        if (isEmpty()) {
            throw new Exception("Cannot remove from empty queue!!");
        }
        int removed = data[front];
        front = (front + 1) % data.length;
        size--;
        return removed;
    }
    public int front() throws Exception {
        if (isEmpty()) {
            throw new Exception("Queue is empty!!");
        }
        return data[0];
    }
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
        }
        int i = front;
        do {
            System.out.print(data[i] + " ");
            i = (i + 1) % data.length;
        }while (i != end);
        System.out.println("END");
    }
}
