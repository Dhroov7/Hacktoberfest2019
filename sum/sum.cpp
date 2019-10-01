#include <bits/stdc++.h>
using namespace std;

int main() {
	int nums[10000], n, sum=0;
	cout<<"Enter no. of numbers in the array: ";
	cin>>n;
	cout<<"Enter the numbers";
	for(int i=0; i<n; i++) cin>>nums[i];
	for(int i=0; i<n; i++) sum+=nums[i];
	cout<<"The sum is: "<<sum;
	return 0;
}
