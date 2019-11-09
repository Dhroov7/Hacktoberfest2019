#include <iostream>

using namespace std;
int add ()
{
    int a, sum = 0, tnum = 0;
    cout << "For Addition " << endl;
    cout << "Enter first number  " << endl;
    cin >> a;
    while (a != -1) { 
        sum = sum + a;
        tnum++;
        cout << "Enter another number or -1 to find the answer " << endl;
        cin >> a;
    }
    cout << "Total number you entered " << tnum << endl;
    cout << "Sum is : " << sum;
}

int main ()
{
	add();
	return 0;
}
