// Reverse a given array

#include<iostream>
using namespace std;

void reverseArray(int arr[], int start, int end) {
    while (start < end) {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
        start++;
        end--;
    }
}

void printArray(int arr[], int size) {
    for (int i = 0; i < size; i++) {
        cout<<arr[i]<<" ";
    }
    cout<<endl;
}

int main() {
    int n, avg;
    int max;
    cout<<"Enter the number of elements in the array: "<<endl;
    cin>>n;
    cout<<"Enter the array elements"<<endl;
    int arr[n];
    for (int i = 0; i < n; i++) {
        cin>>arr[i];
    }
    cout<<"The array is: "<<endl;
    printArray(arr, n);
    reverseArray(arr, 0, n - 1);
    cout<<"The reverse array is: "<<endl;
    printArray(arr, n);
    return 0;
}