// Author: Proma Roy
// GITHUB: https://github.com/promaroy

// program to print fibonacci series using recursion upto the nth term... in c++

#include<bits/stdc++.h>
using namespace std;
int fib(int in)
{
  if(in<=1)
  {
    return in;
  }
  else
  {
    return fib(in-1)+fib(in-2);
  }
}
int main()
{
  int n=12;//take any value and print upto that term....
for(int i=0;i<n;i++)
  cout<<fib(i)<<" ";
cout<<endl;  


}
