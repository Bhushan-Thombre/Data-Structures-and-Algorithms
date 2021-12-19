// Stack implementation using Linked List

#include <iostream>
using namespace std;

struct Node
{
    int data;
    Node *next;
};

Node *top = NULL;

// Time Complexity = O(1) constant
void push(int value)
{
    Node *node = new Node();
    node->data = value;
    node->next = top;
    top = node;
}

// Time complexity = O(1) constant
void pop()
{
    Node *node = top;
    if (node == NULL)
    {
        cout << "Stack is Empty!" << endl;
    }
    else
    {
        top = top->next;
        delete (node);
    }
}

// Time Complexity = O(1) constant
void isEmpty()
{
    Node *node = top;
    if (node == NULL)
    {
        cout << "Stack is Empty!" << endl;
    }
    else
    {
        cout << "Stack is not Empty" << endl;
    }
}

// Time Complexity = O(N)
void size()
{
    int size = 0;
    Node *node = top;
    if (node == NULL)
    {
        cout << "The size of the stack is: " << size << endl;
    }
    else
    {
        while (node != NULL)
        {
            node = node->next;
            size++;
        }
        cout << "The size of the stack is: " << size << endl;
    }
}

// Time Complexity = O(N)
void display()
{
    cout << " ------------------------------------------------------- " << endl;
    Node *node = top;
    if (top == NULL)
    {
        cout << "Stack is Empty!" << endl;
    }
    else
    {
        while (node != NULL)
        {
            cout << node->data << endl;
            node = node->next;
        }
    }
}

int main()
{
    int choice, value;
    int flag = 1;
    cout << " ------------------------------------------------------- " << endl;
    while (flag == 1)
    {
        cout << "Enter the operation you want to perform: " << endl;
        cout << " ------------------------------------------------------- " << endl;
        cout << "1. Push" << endl
             << "2. POP" << endl
             << "3. Display Stack" << endl
             << "4. Check wheather the stack is Empty" << endl
             << "5. Size of the Stack" << endl
             << "6. Exit" << endl;
        cout << " ------------------------------------------------------- " << endl;
        cin >> choice;
        switch (choice)
        {
        case 1:
            cout << "Enter the value you want to push: " << endl;
            cin >> value;
            push(value);
            cout << " ------------------------------------------------------- " << endl;
            break;
        case 2:
            pop();
            cout << " ------------------------------------------------------- " << endl;
            break;
        case 3:
            display();
            cout << " ------------------------------------------------------- " << endl;
            break;
        case 4:
            isEmpty();
            cout << " ------------------------------------------------------- " << endl;
            break;
        case 5:
            size();
            cout << " ------------------------------------------------------- " << endl;
            break;
        case 6:
            flag = 0;
            break;
        }
    }
    return 0;
}