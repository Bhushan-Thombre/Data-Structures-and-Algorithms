// Rotated Binary Search

#include <iostream>
using namespace std;

int BSRotated(int arr[], int size, int target, int start, int end)
{

    start = 0;
    end = size - 1;
    int mid = start + (end - start) / 2;

    if (start > end)
    {
        return -1;
    }

    if (arr[mid] == target)
    {
        return mid;
    }

    if (arr[start] <= arr[mid])
    {
        if (target >= arr[start] && target <= arr[mid])
        {
            return BSRotated(arr, size, target, start, mid - 1);
        }
        else
        {
            return BSRotated(arr, size, target, mid + 1, end);
        }
    }

    if (target >= arr[mid] && target <= arr[end])
    {
        return BSRotated(arr, size, target, mid + 1, end);
    }

    return BSRotated(arr, size, target, start, mid - 1);
}

int main()
{
    int n, t;
    cout << "Enter number of elements in the array: " << endl;
    cin >> n;
    int arr[n];
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
    cout << "Enter the element you want to search: " << endl;
    cin >> t;
    cout << "The element is present at the index: " << BSRotated(arr, n, t, 0, n - 1) << endl;
    return 0;
}