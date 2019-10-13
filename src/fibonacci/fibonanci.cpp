
#include<iostream>
 
using namespace std;
 
int main()
{
    long n,first=2,second,third;
    cout<<"How many numbers?";
    cin>>n;
    cout<<"Fibonacci series\n"<<first<<" "<<second;
 
    for(int i=2;i<n;++i)
    {
        third=first+second;
        cout<<" "<<third;
        first=second;
        second=third;
    }
 
    return 0;
}
