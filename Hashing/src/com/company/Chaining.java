// Hash Function: A function that converts a given big phone number to a small practical integer value. The mapped integer value is used as an index in the hash table. In simple terms, a hash function maps a big number or string to a small integer that can be used as an index in the hash table.
// A good hash function should have following properties:
// It should be efficiently computable.
// It should uniformly distribute the keys (Each table position be equally likely for each key).

// Hash Table: An array that stores pointers to records corresponding to a given phone number.
// An entry in hash table is NIL if no existing phone number has hash function value equal to the index for the entry.

// Collision Handling: Since a hash function gets us a small number for a big key, there is a possibility that two keys result in the same value.
//      The situation where a newly inserted key maps to an already occupied slot in the hash table is called collision and must be handled using some collision handling technique.
//      Following are the ways to handle collisions:
// Chaining:The idea is to make each cell of the hash table point to a linked list of records that have the same hash function value.
//      Chaining is simple, but it requires additional memory outside the table.
// Open Addressing: In open addressing, all elements are stored in the hash table itself. Each table entry contains either a record or NIL.
//      When searching for an element, we one by one examine the table slots until the desired element is found or it is clear that the element is not present in the table


package com.company;

import java.util.ArrayList;
import java.util.LinkedList;

public class Chaining {

    public static void main(String[] args) {
        HashChaining hashChaining = new HashChaining(7);

        hashChaining.insert(70);
        hashChaining.insert(71);
        hashChaining.insert(9);
        hashChaining.insert(56);
        hashChaining.insert(72);

        System.out.println("Search for 56");
        System.out.println(hashChaining.search(56));
        System.out.println("Search for 57");
        System.out.println(hashChaining.search(57));

        System.out.println("Search for 72");
        System.out.println(hashChaining.search(72));
        hashChaining.delete(72);
        System.out.println("72 Deleted");
        System.out.println("Search for 72");
        System.out.println(hashChaining.search(72));
    }
}

class HashChaining {
    int bucket;
    ArrayList<LinkedList<Integer>> table;

    public HashChaining(int bucket) {
        this.bucket = bucket;
        table = new ArrayList<LinkedList<Integer>>();
        for (int i = 0; i < bucket; i++) {
            table.add(new LinkedList<Integer>());
        }
    }

    void insert(int key) {
        int i = key % bucket;
        table.get(i).add(key);
    }

    boolean search(int key) {
        int i = key % bucket;
        return table.get(i).contains(key);
    }

    void delete(int key) {
        int i = key % bucket;
        table.get(i).remove((Integer) key);
    }

}
