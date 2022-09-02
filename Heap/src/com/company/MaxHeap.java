// Max Heap

package com.company;

public class MaxHeap {
    public static void main(String[] args){
        Heap heap = new Heap(5);
        heap.insert(1);
        heap.insert(2);
        heap.insert(3);
        System.out.println(heap.toString());
        heap.delete(2);
        System.out.println(heap.toString());
        heap.insert(5);
        System.out.println(heap.toString());
        heap.increaseKey(2, 2);
        System.out.println(heap.toString());
        System.out.println(heap.extractMax());
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

        public int parent(int i ) {
            return (i - 1) / 2;
        }

        public int left(int i) {
            return (2 * 1) + 1;
        }

        public int right(int i) {
            return (2 * i) + 2;
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
            for (int i = size - 1; i != 0 && arr[parent(i)] < arr[i];) {
                int temp = arr[i];
                arr[i] = arr[parent(i)];
                arr[parent(i)] = temp;
                i = parent(i);
            }
        }

        // Heapify
        // Time Complexity = O(logN)
        public void heapify(int i) {
            int left = left(i);
            int right = right(i);
            int largest = i;
            if (left < size && arr[left] > arr[i]) {
                largest = left;
            }
            if (right < size && arr[right] > arr[largest]) {
                largest = right;
            }
            if (largest != i) {
                int temp = arr[i];
                arr[i] = arr[largest];
                arr[largest] = temp;
                heapify(largest);
            }
        }

        // Extract Max
        // Time Complexity = O(logN)
        public int extractMax() {
            if (size == 0) {
                return Integer.MIN_VALUE;
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

        // Increase Key. Replace the key at given index with the given key
        // Time Complexity = O(logN)
        public void increaseKey(int i, int key) {
            arr[i] = key;
            while (i != 0 && arr[parent(i)] < arr[i]) {
                int temp = arr[i];
                arr[i] = arr[parent(i)];
                arr[parent(i)] = temp;
                i = parent(i);
            }
        }

        // Deletion
        // Time complexity = O(logN)
        public void delete(int i) {
            increaseKey(i, Integer.MAX_VALUE);
            extractMax();
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
