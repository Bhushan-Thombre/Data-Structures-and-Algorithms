// Queue implementation using array

#include <iostream>
using namespace std;

#define N 4
int queue[N];
int front, rear = -1;

// Time complexity = O(1) constant
void enqueue(int value)
{
    if (rear == (N - 1))
    {
        cout << "Queue is full" << endl;
    }
    else if (front == -1 && rear == -1)
    {
        rear = 0;
        queue[rear] = value;
    }
    else
    {
        rear++;
        queue[rear] = value;
    }
}

// Time complexity = O(1) constant
void dequeue()
{
    if (front == -1 && rear == -1)
    {
        cout << "Queue is empty" << endl;
    }
    else if (front == rear)
    {
        front = rear = -1;
    }
    else
    {
        front++;
    }
}

// Time complexity = O(1) constant
void first()
{
    if (front == -1 && rear == -1)
    {
        cout << "Queue is empty" << endl;
    }
    else
    {
        cout << "The value of element present at front is: " << queue[front] << endl;
    }
}

// Time complexity = O(1) constant
void last()
{
    if (front == -1 && rear == -1)
    {
        cout << "Queue is empty" << endl;
    }
    else
    {
        cout << "The value of element present at rear is " << queue[rear] << endl;
    }
}

// Time complexity = O(1) constant
void isEmpty()
{
    if (front == -1 && rear == -1)
    {
        cout << "Queue is empty, Underflow condition" << endl;
    }
    else
    {
        cout << "Queue is not empty" << endl;
    }
}

// Time complexity = O(1) constant
void isFull()
{
    if ((front + rear) == (N - 1))
    {
        cout << "Queue is full, Overflow condition" << endl;
    }
    else
    {
        cout << "Queue is not full" << endl;
    }
}

// Time complexity = O(N)
void display()
{
    cout << " ------------------------------------------------ " << endl;
    if (front == -1 && rear == -1)
    {
        cout << "Queue is empty" << endl;
    }
    else
    {
        for (int i = front; i <= rear; i++)
        {
            cout << queue[i] << " ";
        }
        cout << endl;
    }
}

int main()
{
    int choice, value;
    int flag = 1;
    cout << " ------------------------------------------------ " << endl;
    cout << "Implementation of Queue using Array" << endl;
    cout << " ------------------------------------------------ " << endl;
    while (flag == 1)
    {
        cout << "Enter the operation you want to perform: " << endl;
        cout << " ------------------------------------------------ " << endl;
        cout << "1. Enqueue" << endl
             << "2. Dequeue" << endl
             << "3. Front" << endl
             << "4. Last" << endl
             << "5. Check wheather the queue is Empty or not." << endl
             << "6. Check wheather the queue is Full or not" << endl
             << "7. Display" << endl
             << "8. Exit" << endl;
        cout << " ------------------------------------------------ " << endl;
        cin >> choice;
        switch (choice)
        {
        case 1:
            cout << "Enter the value you want to Enqueue" << endl;
            cin >> value;
            enqueue(value);
            cout << " ------------------------------------------------ " << endl;
            break;
        case 2:
            dequeue();
            cout << " ------------------------------------------------ " << endl;
            break;
        case 3:
            first();
            cout << " ------------------------------------------------ " << endl;
            break;
        case 4:
            last();
            cout << " ------------------------------------------------ " << endl;
            break;
        case 5:
            isEmpty();
            cout << " ------------------------------------------------ " << endl;
            break;
        case 6:
            isFull();
            cout << " ------------------------------------------------ " << endl;
            break;
        case 7:
            display();
            cout << " ------------------------------------------------ " << endl;
            break;
        case 8:
            flag = 0;
            break;
        }
    }
}