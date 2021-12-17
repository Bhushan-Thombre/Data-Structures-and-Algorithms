// Program to perforn string operations like finding length, copying the string, reversing a string, comparing two strings and concatenating strings

#include <iostream>
using namespace std;

class Strings
{
public:
    // Function to find the length of the string
    void len(char str[100])
    {
        int count = 0;
        for (int i = 0; str[i] != '\0'; i++)
        {
            count++;
        }
        cout << "The length of the string is: " << count << endl;
        cout << "----------------------------------------------" << endl;
    }

    // Function to copy string
    void copy(char str[100])
    {
        int i;
        char str1[100];
        for (i = 0; str[i] != '\0'; i++)
        {
            str1[i] = str[i];
        }
        str1[i] = '\0';
        cout << "The copied string is: " << str1 << endl;
        cout << "----------------------------------------------" << endl;
    }

    // Function to concatenate strings
    void concatenate(char str[100])
    {
        int i, j;
        char str1[100];
        cout << "Enter the string that you want to concatenate: " << endl;
        cin >> str1;
        for (i = 0; str[i] != '\0'; i++)
        {
        }
        for (j = 0; str1[j] != '\0'; j++, i++)
        {
            str[i] = str1[j];
        }
        str[i] = '\0';
        cout << "The concatenated string is: " << str << endl;
        cout << "----------------------------------------------" << endl;
    }

    // Function to compare two strings
    void compare(char str[100])
    {
        int i, j;
        char str1[100];
        cout << "Enter the string you want to compare with: " << endl;
        cin >> str1;
        for (i = 0; str[i] != '\0'; i++)
        {
        }
        for (j = 0; str1[j] != '\0'; j++)
        {
        }
        if (i > j)
        {
            cout << "The original string is bigger than the entered string." << endl;
        }
        else if (i < j)
        {
            cout << "The original string is smaller than the entered string." << endl;
        }
        else
        {
            cout << "The strings are equal" << endl;
        }
        cout << "----------------------------------------------" << endl;
    }

    // Function to reverse a string
    void reverse(char str[100])
    {
        int i;
        for (i = 0; str[i] != '\0'; i++)
        {
        }
        cout << "The reversed string is: " << endl;
        for (i >= 0; i--;)
        {
            cout << str[i];
        }
        str[i] = '\0';
        cout << endl;
        cout << "----------------------------------------------" << endl;
    }
};

int main()
{
    Strings s;
    char str[100];
    int n;
    string j;
    cout << "----------------------------------------------" << endl;
    cout << "Enter a string: " << endl;
    cin >> str;
    cout << "----------------------------------------------" << endl;
    do
    {
        cout << "Enter the operation you want to perform: " << endl;
        cout << "1. Length" << endl
             << "2. Copy" << endl
             << "3. Concatenate" << endl
             << "4. Compare" << endl
             << "5. Reverse" << endl;
        cout << "----------------------------------------------" << endl;
        cin >> n;
        cout << "----------------------------------------------" << endl;
        switch (n)
        {
        case 1:
            s.len(str);
            break;
        case 2:
            s.copy(str);
            break;
        case 3:
            s.concatenate(str);
            break;
        case 4:
            s.compare(str);
            break;
        case 5:
            s.reverse(str);
            break;
        }
        cout << "Do you want to perform the operations again: (Y/N)" << endl;
        cin >> j;
    } while (j == "Y" || j == "y");

    return 0;
}