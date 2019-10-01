#include <iostream>

using namespace std;

int rec_fact(int n){

  if(n==1 || n==0) return 1;

  else return (n*rec_fact(n-1));

}

int main(){

	int n;

  cout<<" Enter the number whose factorial is to be found \n";

  cin>>n;

  cout<<rec_fact(n)<<endl;

	return 0;
}
