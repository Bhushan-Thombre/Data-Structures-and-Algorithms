// Selection sort
// Time complexity = O(N * N)

#include <iostream>
using namespace std;

int getMaxIndex(int arr[], int start, int end)
{
    int max = start;
    for (int i = 0; i <= end; i++)
    {
        if (arr[max] < arr[i])
        {
            max = i;
        }
    }
    return max;
}

void swapped(int arr[], int first, int second)
{
    int temp = arr[first];
    arr[first] = arr[second];
    arr[second] = temp;
}

void selectionSort(int arr[], int size)
{
    for (int i = 0; i < size; i++)
    {
        int last = size - i - 1;
        int maxindex = getMaxIndex(arr, 0, last);
        swapped(arr, maxindex, last);
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
    selectionSort(arr, n);
    cout << "The sorted array is: " << endl;
    for (int k = 0; k < n; k++)
    {
        cout << arr[k] << " ";
    }
    cout << endl;
    return 0;
}