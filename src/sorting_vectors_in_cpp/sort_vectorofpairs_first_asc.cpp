//Author dvlpsh
/*A C++ program to demonstrate various cool tricks possible using a vector in C++
g++ sort_pairofvector_first_asc.cpp -o vec -std=c++11
*/

#include <iostream>
#include<vector>
#include<bits/stdc++.h>
using namespace std;


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
	
	//sort pair of vectors first element ascending
	//sorts by second element when two or more first element is same
	sort(v.begin(), v.end());
	cout<<"After sorting pair of vectors by first element, ascending\n"<<endl;
	display(v,v.size());
		
	return 0;
}
