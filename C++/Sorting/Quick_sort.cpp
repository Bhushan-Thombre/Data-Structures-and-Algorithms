// Quick Sort
// Time complexity - O(NLogN)
// Space complexity - O(1)

#include <iostream>
using namespace std;

void quickSort(int arr[], int size, int low, int high)
{
    if (low >= high)
    {
        return;
    }
    int start = low;
    int end = high;
    int mid = start + (end - start) / 2;
    int pivot = arr[mid];

    while (start <= end)
    {
        while (arr[start] < pivot)
        {
            start++;
        }
        while (arr[end] > pivot)
        {
            end--;
        }
        if (start <= end)
        {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
    quickSort(arr, size, low, end);
    quickSort(arr, size, start, high);
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
    quickSort(arr, n, 0, n - 1);
    cout << "The sorted array is: " << endl;
    for (int k = 0; k < n; k++)
    {
        cout << arr[k] << " ";
    }
    cout << endl;
    return 0;
}