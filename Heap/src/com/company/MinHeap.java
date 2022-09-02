// A Heap is a Tree based data structure

// A Heap is a complete tree (All levels are completely filled except possibly the last level and the last level has all keys as left as possible).
// A Heap is either Min Heap or Max Heap. In a Min-Heap, the key at root must be minimum among all keys present in the Binary Heap.
// The same property must be recursively true for all nodes in the Tree. Max Heap is similar to Heap.

// Binary Heap: A Binary Heap is a heap where each node can have at most two children.
// In other words, a Binary Heap is a complete Binary Tree satisfying the above-mentioned properties.

// Min Heap

package com.company;

public class MinHeap {

    public static void main(String[] args) {
        Heap heap = new Heap(3);
        heap.insert(3);
        heap.insert(1);
        heap.insert(2);
        System.out.println(heap.toString());
        heap.delete(2);
        System.out.println(heap.toString());
        heap.insert(4);
        System.out.println(heap.toString());
        heap.decreaseKey(2, 2);
        System.out.println(heap.toString());
        System.out.println(heap.extractMin());
    }

    public static class Heap {
        int capacity;
        int size;
        int[] arr;

        public Heap(int capacity) {
            this.capacity = capacity;
            size = 0;
            arr = new int[capacity];
        }

        public int left(int i) {
            return (2 * i) + 1;
        }

        public int right(int i) {
            return (2 * i) + 2;
        }

        public int parent(int i) {
            return (i - 1) / 2;
        }

        // Insertion
        // Time Complexity = O(logN)
        public void insert(int key) {
            if (size == capacity) {
                System.out.println("Added too many elements");
                return;
            }
            size++;
            arr[size - 1] = key;
            for (int i = size - 1; i != 0 && arr[parent(i)] > arr[i];) {
                int temp = arr[i];
                arr[i] = arr[parent(i)];
                arr[parent(i)] = temp;
                i = parent(i);
            }
        }

        // Heapify
        // Time Complexity = O(logN)
        // Space Complexity = O(logN)
        public void heapify(int i) {
            int left = left(i);
            int right = right(i);
            int smallest = i;
            if (left < size && arr[left] < arr[i]) {
                smallest = left;
            }
            if (right < size && arr[right] < arr[smallest]) {
                smallest = right;
            }
            if (smallest != i) {
                int temp = arr[smallest];
                arr[smallest] = arr[i];
                arr[i] = temp;
                heapify(smallest);
            }
        }

        // Extract Minimum
        // Time Complexity = O(logN)
        // Space Complexity = O(logN)
        public int extractMin() {
            if (size == 0) {
                return Integer.MAX_VALUE;
            }
            if (size == 1) {
                size--;
                return arr[0];
            }

            int temp = arr[0];
            arr[0] = arr[size - 1];
            arr[size - 1] = temp;
            size--;
            heapify(0);

            return arr[size];
        }

        // Replace the value at index i with given value such that the heap property does not violate
        // Time Complexity = O(logN)
        public void decreaseKey(int i, int value) {
            arr[i] = value;
            while (i != 0 && arr[parent(i)] > arr[i]) {
                int temp = arr[i];
                arr[i] = arr[parent(i)];
                arr[parent(i)] = temp;
                i = parent(i);
            }
        }

        // Deletion
        // Time Complexity = O(logN)
        public void delete(int i) {
            decreaseKey(i, Integer.MIN_VALUE);
            extractMin();
        }

        public String toString() {
            if (capacity == 0) {
                return "No elements";
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append('[');
                for (int i = 0; i < arr.length; i++) {
                    stringBuilder.append(arr[i]);
                    stringBuilder.append(',');
                }
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                stringBuilder.append(']');
                return stringBuilder.toString();
            }
        }
    }
}
