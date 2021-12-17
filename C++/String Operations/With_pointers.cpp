// Program to perform string operations like finding length, coping a string, concatenating 2 strings, comparing strings and reversing
// a string using pointers.

#include <iostream>
using namespace std;

class Strings
{
public:
    // Function to find the length of the string
    void length(char *str)
    {
        int count = 0;
        while (*str != '\0')
        {
            count++;
            str++;
        }
        cout << "The length of the string is: " << count << endl;
        cout << "------------------------------------" << endl;
    }

    // Function to copy string
    void copy(char *str)
    {
        char str1[100];
        char *original = &str[0];
        char *copy = &str1[0];
        while (*original != '\0')
        {
            *copy = *original;
            copy++;
            original++;
        }
        *copy = '\0';
        cout << "The copied string is: " << str1 << endl;
        cout << "------------------------------------" << endl;
    }

    // Function to concatenate strings
    void concatenate(char *str)
    {
        int i, j;
        char str1[100];
        cout << "Enter the string which you want to concatenate: " << endl;
        cin >> str1;
        char *con = str1;
        for (i = 0; *(str + i) != '\0'; i++)
        {
        }
        for (j = 0; *(con + j) != '\0'; j++, i++)
        {
            *(str + i) = *(con + j);
        }
        *(str + i) = '\0';
        cout << "The concatenated string is: " << str << endl;
        cout << "------------------------------------" << endl;
    }

    // Function to compare 2 strings
    void compare(char *str)
    {
        int i, j;
        char str1[100];
        cout << "Enter the string you want to compare with: " << endl;
        cin >> str1;
        char *com = str1;
        for (i = 0; *(str + i) != '\0'; i++)
        {
        }
        for (j = 0; *(com + j) != '\0'; j++)
        {
        }
        if (i > j)
        {
            cout << "The original string is bigger than the entered string. " << endl;
        }
        else if (i < j)
        {
            cout << "The original string is smaller than the entered string. " << endl;
        }
        else
        {
            cout << "The strings are equal." << endl;
        }
        cout << "------------------------------------" << endl;
    }

    // Function to reverse the string
    void reverse(char *str)
    {
        int i;
        for (i = 0; *(str + i) != 0; i++)
        {
        }
        cout << "The reversed string is: " << endl;
        for (i >= 0; i--;)
        {
            cout << *(str + i);
        }
        *(str + i) = '\0';
        cout << endl;
        cout << "------------------------------------" << endl;
    }
};

int main()
{
    int n;
    Strings s;
    string j;
    char str[100];
    cout << "------------------------------------" << endl;
    cout << "Enter the string: " << endl;
    cin >> str;
    cout << "------------------------------------" << endl;
    do
    {
        cout << "Enter the operation you want to perform: " << endl;
        cout << "1. Length" << endl
             << "2. Copy" << endl
             << "3. Concatenate" << endl
             << "4. Compare" << endl
             << "5. Reverse" << endl;
        cout << "------------------------------------" << endl;
        cin >> n;
        cout << "------------------------------------" << endl;
        switch (n)
        {
        case 1:
            s.length(str);
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
        cout << "Do you want to perfrom the operations again: (Y/N)" << endl;
        cin >> j;
    } while (j == "Y" || j == "y");
}