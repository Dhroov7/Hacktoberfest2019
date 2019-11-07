#include <iostream>

using namespace std;
int recSearch(int arr[], int l,
              int r, int x)
{
    if (r < l)
        return -1;
    if (arr[l] == x)
        return l;
    if (arr[r] == x)
        return r;
    return recSearch(arr, l + 1,
                     r - 1, x);
}

int main()
{
    cout << "Insert array size:\n";
    int arraysize;
    cin >> arraysize;
    cout << "Please insert number to store in array:\n";
    int arr[arraysize], i;
    for (int z = 0; z < arraysize; z++)
    {
        cin >> arr[z];
    }
    int n = sizeof(arr) / sizeof(arr[0]);
    cout << "What number do you want to search?\n";
    int x;
    cin >> x;
    int index = recSearch(arr, 0, n - 1, x);
    if (index != -1)
        cout << "Element " << x
             << " is present at index "
             << index;
    else
        cout << "Element " << x
             << " is not present";
    return 0;
}