#include<bits/stdc++.h>
using namespace std;
int main(void)
{
    int N;
    cout<<"Enter N: ";
    cin>>N;
    int dp[N];
    if(N==1)
    {
        cout<<"0";
        return 0;
    }
    else if(N==2)
    {
        cout<<"1";
        return 0;
    }
    dp[0]=0;dp[1]=1;
    for(int i=2;i<N;i++)
    {
        dp[i] = dp[i-1]+dp[i-2];
    }
    cout<<dp[N-1];
    return 0;
}