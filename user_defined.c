#include<stdio.h>
int checkprimenumber(int n);
int checkarmstromnumber(int n);
int main()
{
    int n,flag,flag1;
    printf("Enter the number : ");
    scanf("%d",&n);
    //checking number is prime or not 
    flag=checkprimenumber(n);
        printf("%d\n",flag);

    if(flag==1)
    {
        printf("number is prime \n");
    }
    else
    {
        printf("Number is not prime\n");
    }
    //checking number is armstrom or not

    flag1=checkarmstromnumber(n);
           printf("%d\n flag is ",flag1); 
    if(flag1==1)
    {
        printf("Number is armstrom\n");
    }
    else
    {
        printf("Number is not armstrom\n");
    }
    
return 0;
}
int checkprimenumber(int n)
{
    int i,flag=0;
    for(i=1;i<=n/2;i++)
    {
        if(n%i==0)
        flag++;
    }
return flag;
}
    int checkarmstromnumber(int n)
{
    int flag1,i,remainder,orignalnumber,result=0;
    orignalnumber = n;
    while(orignalnumber !=0)
    {
        remainder = orignalnumber%10;
        result += remainder*remainder*remainder;
        orignalnumber /=10;
        printf("result %d \n153",result);
    }
    if(result == n)
    {
        flag1 =1;
    }
    else
        {
            flag1 =0;
        }
    return flag1;
}  
    

