#include <iostream>
#include <stdlib.h>

using namespace std;

void print(int p)
{
    if (p == 0)
        return;
    cout << p;
    print(p-1);
    return;
}

int Fibonaci(int n)
{
    if (n == 0)
        return 0;
    else if (n == 1)
        return 1;
    return (Fibonaci(n - 1) + Fibonaci(n - 2));
}

bool isPrime(int p, int i = 2)
{
    if (i == p)
        return 1; //or better  if (i*i>p) return 1;
    if (p % i == 0)
        return 0;
    return isPrime(p, i + 1);
}

int sum(int num)
{
    if (num == 0)
        return 0;
    else
        return num + sum(num - 1);
}

int sum(int num, int total)
{
    if (num <= 0)
        return num;
    else
    {
        return total + num;
    }
}

int main()
{
    int number;
    cout<<"Please insert number :";
    cin>>number;
    print(number);
}