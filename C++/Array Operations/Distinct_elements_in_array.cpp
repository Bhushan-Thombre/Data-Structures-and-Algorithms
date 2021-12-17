// Calculate the number of distinct elements in an array

#include<iostream>
using namespace std;

int main() {
    int arr[5] = {10, 20, 30, 10, 20};
    cout<<"The array is: ";
    for (int k = 0; k < 5; k++) {
        cout<<arr[k]<<" ";
    }
    cout<<endl;
    int count = 0;
    bool isDistinct = true;

    for (int i = 0; i < 5; i++) {
        isDistinct = true;
        for (int j = i - 1; j >= 0; j--) {
            if (arr[i] == arr[j]) {
                isDistinct = false;
                break;
            }
        }
        if (isDistinct == true) {
                count++;
            }
    }

    cout<<"The number of distict elements in the array are: "<<count;
}