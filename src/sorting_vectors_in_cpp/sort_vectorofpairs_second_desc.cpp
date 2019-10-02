//Author dvlpsh
/*A C++ program to demonstrate various cool tricks possible using a vector in C++
Compile using g++ sort_pairofvector_second_desc.cpp -o vec -std=c++11
*/

#include <iostream>
#include<vector>
#include<bits/stdc++.h>
using namespace std;


static bool sortBySecDesc(const pair<int, int> &a, const pair<int, int> &b)
{
	if(a.second == b.second)
		return (a.first>b.first);
	return (a.second>b.second);
}

void display(vector<pair<int, int>> v, int n)
{
	cout<<"Displaying inputs"<<endl;
	
	for(int i=0; i<n; i++)
		cout<<v[i].first<<" "<<v[i].second<<endl;
	cout<<"\n";
}


int main()
{
	int n, c1, c2;
	
	vector<pair<int,int>> v;//initialise a vector of pairs named v
	
	cout<<"Enter the number of inputs"<<endl;
	cin>>n;
	cout<<"Enter key value pairs"<<endl;
	
	for(int i=0; i<n; i++)
	{
		cin>>c1>>c2;
		v.push_back(make_pair(c1,c2));
	}
	
	//display elements after taking input
	//display(v,n);
	
	//sort by second descending, using  sortBySecDesc as user defined comaparator function
	sort(v.begin(), v.end, sortBySecDesc);
	cout<<"After sorting pair of vectors by second element, descending\n"<<endl;
	display(v,v.size());
		
	
	return 0;
}
