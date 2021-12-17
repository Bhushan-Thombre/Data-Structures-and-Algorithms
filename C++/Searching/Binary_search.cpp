// Binary search
// Time complexity = O(Log N)

#include <iostream>
using namespace std;

int binarySearch(int arr[], int size, int target, int start, int end)
{

    start = 0;
    end = size - 1;
    int mid = start + (end - start) / 2;

    if (size == 0)
    {
        return -1;
    }

    while (start <= end)
    {
        if (arr[mid] > target)
        {
            end = mid - 1;
        }
        else if (arr[mid] < target)
        {
            start = mid + 1;
        }
        else
        {
            return mid;
        }
    }
    return -1;
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
    cout << "The element is present at the index: " << binarySearch(arr, n, t, 0, n - 1) << endl;
    return 0;
}