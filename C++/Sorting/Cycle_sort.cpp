// Cycle sort
// Time complexity = O(N)
// For numbers for 1 to (n - 1)

#include <iostream>
using namespace std;

void swapped(int arr[], int first, int second)
{
    int temp = arr[first];
    arr[first] = arr[second];
    arr[second] = temp;
}

void cycleSort(int arr[], int size)
{
    int i = 0;
    while (i < size)
    {
        int correctindex = arr[i] - 1;
        if (arr[i] != arr[correctindex])
        {
            swapped(arr, i, correctindex);
        }
        else
        {
            i++;
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
    cycleSort(arr, n);
    cout << "The sorted array is: " << endl;
    for (int k = 0; k < n; k++)
    {
        cout << arr[k] << " ";
    }
    cout << endl;
    return 0;
}