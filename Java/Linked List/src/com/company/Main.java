package com.company;

public class Main {

    public static void main(String[] args) {
        SLL list = new SLL();
        list.insertFirst(3);
        list.insertFirst(2);
        list.insertFirst(8);
        list.insertFirst(17);
        list.insertLast(99);
        list.insert(100, 3);
        list.display();
        System.out.println(list.deleteFirst());
        list.display();
        System.out.println(list.deleteLast());
        list.display();
        System.out.println(list.delete(2));
        list.display();


        DLL list1 = new DLL();
        list1.insertFirst(3);
        list1.insertFirst(2);
        list1.insertFirst(8);
        list1.insertFirst(17);
        list1.insertLast(99);
        list1.insert(8, 65);
        list1.display();


        CLL list2 = new CLL();
        list2.insert(23);
        list2.insert(3);
        list2.insert(19);
        list2.insert(75);
        list2.display();
        list2.delete(19);
        list2.display();
    }
}
