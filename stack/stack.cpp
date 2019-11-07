#include <iostream>
#include <stack>
#include <string>
using namespace std;

int main()
{
    stack<string> mystack;

    int i;
    cout << "Please put how many number do you want to fill? ";
    cin >> i;
    for (int x = 0; x < i; x++)
    {
        string asd;
        cout << "Please insert string at index " << x<<" : ";
        cin >> asd;
        mystack.push(asd);
    }

    cout << "The result is below\n";
    while (!mystack.empty())
    {
        cout << ' ' << mystack.top();
        mystack.pop();
    }
}