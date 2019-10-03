#include<stdio.h>
#include<math.h>
int main()
{
    int no,real;
    float fl;
    printf("\nEnter a Number : ");
    scanf("%d",&no);
    fl=sqrt(no);
    real=fl;
    if(real==fl)
        printf("%d is a perfect square",no);
    else
        printf("%d is not a perfect square",no);
    return 0;
}
