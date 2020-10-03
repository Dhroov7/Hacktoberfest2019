#include <iostream>
#include <stdio.h>
#include <ctime>

using namespace std;



int main()
{
	time_t t = time(NULL);
	tm* timePtr = localtime(&t);
   int year=timePtr->tm_year+1900;
   cout<<"Next 20 Leap Years are:"<<endl;
   if(year%4!=0)
   	year=year+4-year%4;
   int i=0;
   while(i<20)
   {
   if (year%100!=0)
   {
   	cout<<year<<" ";
    i++;
   }
   else if(year%100==0)
   {
   	if(year%400==0)
   	{
     cout<<year<<" ";
     i++;
    }
   }
   	year=year+4;
   }
   return 0;
}