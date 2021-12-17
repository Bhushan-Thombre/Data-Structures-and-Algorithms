// Bubble sort
// Time complexity = O(N * N)
// Bubble sort is a stable sorting algorithm

#include <iostream>
using namespace std;

void bubbleSort(int arr[], int size)
{
    bool swapped;
    for (int i = 0; i < size; i++)
    {
        swapped = false;
        for (int j = 1; j < size - i; j++)
        {
            if (arr[j - 1] > arr[j])
            {
                int temp = arr[j - 1];
                arr[j - 1] = arr[j];
                arr[j] = temp;
                swapped = true;
            }
        }
        if (!swapped)
        {
            break;
        }
    }
}

int main()
{
    int n;
    cout << "Enter the number of elements in the array: " << endl;
    cin >> n;
    int arr[n], ans[n];
    cout << "Enter the array: " << endl;
    for (int i = 0; i < n; i++)
    {
        cin >> arr[i];
    }
    cout << "The array is: " << endl;
    for (int j = 0; j < n; j++)
    {
        cout << arr[j] << " ";
    }
    cout << endl;
    bubbleSort(arr, n);
    cout << "The sorted array is: " << endl;
    for (int k = 0; k < n; k++)
    {
        cout << arr[k] << " ";
    }
    cout << endl;
    return 0;
}