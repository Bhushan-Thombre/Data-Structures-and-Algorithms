// Calculate the average of all the elements in the array

#include<iostream>
using namespace std;

int main() {
    int n, avg;
    int sum = 0;
    cout<<"Enter the number of elements in the array: "<<endl;
    cin>>n;
    cout<<"Enter the array elements"<<endl;
    int arr[n];
    for (int i = 0; i < n; i++) {
        cin>>arr[i];
    }
    cout<<"The array is: "<<endl;
    for (int j = 0; j < n; j++) {
        cout<<arr[j]<<" ";
    }
    cout<<endl;
    for (int k = 0; k < n; k++) {
        sum = sum + arr[k];
    }
    avg = sum / n;
    cout<<"The average of all the elements in the array is: "<<avg;
}