// nth fibonacci number using dynamic programming in c

#include <stdio.h>
 int fibonacci(int n){
   if(n<=1){
     return n;
   }
   int a[n+1],i;
   a[0]=0;
   a[1]=1;
   for(i=2;i<=n;i++){
     a[i]=a[i-1]+a[i-2];
   }
   return a[n];
 }

 int main(){
   int n;
   printf("Enter the number\n" );
   scanf("%d",&n);
   printf("The corresponding Fibonnaci number is %d\n",fibonacci(n));
   return 0;
 }
