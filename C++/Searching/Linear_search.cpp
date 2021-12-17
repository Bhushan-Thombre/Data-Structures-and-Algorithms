// Linear search
// Time complexity = O(N)

#include <iostream>
using namespace std;

int linearSearch(int arr[], int size, int target)
{
    if (size == 0)
    {
        return -1;
    }
    for (int i = 0; i < size; i++)
    {
        if (arr[i] == target)
        {
            return i;
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
    cout << "The element is present at the index: " << linearSearch(arr, n, t);
    return 0;
}