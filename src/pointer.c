#include<stdio.h>
int main()
{
    int *p, a = 10;
    p = &a;
    printf("\nThe address of a = %p",&a);
    printf("\nThe value at a = %d",a);
    printf("\nThe address of p = %p",&p);
    printf("\nThe value at p = %p",p);
    printf("\nThe value of pointer p = %d\n",*p);
    return 0;

}
