#include<stdio.h>
int main()
{
    int rows,i,j;
    printf("enter the the number of terms ");
    scanf("%d",&rows);
    for(i=1;i<=rows;i++)
    {
        for(j=1;j<=i;j++)
        {
            printf("*");
        }
            printf("\n");
    }
    return 0;
}