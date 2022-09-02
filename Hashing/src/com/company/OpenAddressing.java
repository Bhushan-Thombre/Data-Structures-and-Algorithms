// Linear Probing: (h(x) + i) % capacity. Problem: Clustering
// Quadratic Probing: (h(x) + i * i) % capacity. Problem: Secondary Clustering
// Double Hashing: (h1(x) + h2(x) * i) % capacity.

package com.company;

public class OpenAddressing {
    public static void main(String[] args) {
        HashOA hashOA = new HashOA(7);

        hashOA.insert(49);
        hashOA.insert(56);
        hashOA.insert(72);

        System.out.println("Search for 56");
        if (hashOA.search(56)) {
            System.out.println("56 is present");
        }else {
            System.out.println("56 is not present");
        }

        System.out.println("Delete 56");
        boolean delete = hashOA.delete(56);
        if (delete) {
            System.out.println("56 is deleted");
        }

        System.out.println("Again search for 56");
        if (hashOA.search(56)) {
            System.out.println("56 is present");
        }else {
            System.out.println("56 is not present");
        }
    }
}

class HashOA {
    int capacity;
    int size;
    int[] arr;

    int hash(int key) {
        return key % capacity;
    }

    HashOA(int capacity) {
        this.capacity = capacity;
        size = 0;
        arr = new int[capacity];
        for (int i = 0; i < capacity; i++) {
            arr[i] = -1;
        }
    }

    boolean insert(int key) {
        if (size == capacity) {
            return false;
        }
        int i = hash(key);
        while (arr[i] != -1 && arr[i] != -2 && arr[i] != key) {
            i = (i + 1) % capacity;
        }
        if (arr[i] == key) {
            return false;
        }else {
            arr[i] = key;
            size++;
            return true;
        }
    }

    boolean search(int key) {
        int h = hash(key);
        int i = h;
        while (arr[i] != -1) {
            if (arr[i] == key) {
                return true;
            }
            i = (i + 1) % capacity;
            if (i == h) {
                return false;
            }
        }
        return false;
    }

    boolean delete(int key) {
        int h = hash(key);
        int i = h;
        while (arr[i] != -1) {
            if (arr[i] == key) {
                arr[i] = -2;
                return true;
            }
            i = (i + 1) % capacity;
            if (i == h) {
                return false;
            }
        }
        return false;
    }
}
