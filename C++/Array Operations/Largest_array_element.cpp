// Largest element in an array

#include<iostream>
using namespace std;

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
    for (int j = 0; j < n; j++) {
        cout<<arr[j]<<" ";
    }
    cout<<endl;
    for (int k = 0; k < n; k++) {
        max = arr[0];
        if (arr[k] >= max) {
            max = arr[k];
        }
    }
    cout<<"The largest element in the array is: "<<max;
    return 0;
}