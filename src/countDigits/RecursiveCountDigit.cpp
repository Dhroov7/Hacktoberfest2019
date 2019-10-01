#include <iostream>

using namespace std;

int count_digit(int n)
{
	return (n >= 10)
        ? 1 + count_digit(n/10)
        : 1;
}

int main (void)
{
	int n;
	cout << "Enter digits\t";
	cin >> n;
	cout << "Digit Count is: " << count_digit(n);
	
	return 0;
}
