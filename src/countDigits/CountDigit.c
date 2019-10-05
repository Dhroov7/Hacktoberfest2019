#include<stdio.h>
long long int count(long long int n)
{
	long long int a=0;
	if(n==0)
	{
		return a;
	}
	else
	{
		n=n/10;
		return 1+count(n);
	}
}
int main()
{
	long long int n;
	scanf("%lld",&n);
	long long int c;
	c=count(n);
	printf("%lld\n",c);
}

