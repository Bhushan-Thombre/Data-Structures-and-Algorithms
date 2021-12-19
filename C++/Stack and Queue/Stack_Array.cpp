// Stack implementation using array
// Constant Time complexity of O(1) for all the operations

#include <iostream>
#include <bits/stdc++.h>
using namespace std;
#define size 5
int stac[size];
int top = -1;

void push(int value)
{
    if (top >= (size - 1))
    {
        cout << "Stack is Full, Overflow condition" << endl;
    }
    else
    {
        top++;
        stac[top] = value;
    }
}

void pop()
{
    if (top == -1)
    {
        cout << "Stack is empty!" << endl;
    }
    else
    {
        top--;
    }
}

void isEmpty()
{
    if (top == -1)
    {
        cout << "The Stack is Empty" << endl;
    }
    else
    {
        cout << "Stack is not Empty" << endl;
    }
}

void isFull()
{
    if (top >= (size - 1))
    {
        cout << "Stack is Full, Overflow condition" << endl;
    }
    else
    {
        cout << "Stack is not Full" << endl;
    }
}

void display()
{
    cout << " -------------------------------------------------- " << endl;
    cout << "The stack contains the elements: " << endl;
    if (top == -1)
    {
        cout << "Stack is Empty!" << endl;
    }
    else
    {
        for (int i = top; i >= 0; i--)
        {
            cout << stac[i] << endl;
        }
    }
}

int main()
{
    int flag = 1;
    int choice, value;
    cout << " -------------------------------------------------- " << endl;
    cout << "The size of the stack is: 5" << endl;
    cout << " -------------------------------------------------- " << endl;
    while (flag == 1)
    {
        cout << "Enter the operation you want to perform" << endl;
        cout << " -------------------------------------------------- " << endl;
        cout << "1. Push" << endl
             << "2. POP" << endl
             << "3. Display Stack" << endl
             << "4. Check wheather the stack is full" << endl
             << "5. Check wheather the stack is empty" << endl
             << "6. Exit" << endl;
        cout << " -------------------------------------------------- " << endl;
        cin >> choice;
        switch (choice)
        {
        case 1:
            cout << "Enter the value" << endl;
            cin >> value;
            push(value);
            cout << " -------------------------------------------------- " << endl;
            break;
        case 2:
            pop();
            cout << " -------------------------------------------------- " << endl;
            break;
        case 3:
            display();
            cout << " -------------------------------------------------- " << endl;
            break;
        case 4:
            isFull();
            cout << " -------------------------------------------------- " << endl;
            break;
        case 5:
            isEmpty();
            cout << " -------------------------------------------------- " << endl;
            break;
        case 6:
            flag = 0;
            break;
        }
    }
    return 0;
}