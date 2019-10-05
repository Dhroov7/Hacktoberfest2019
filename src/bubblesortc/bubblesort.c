#include<stdio.h>
void bubblesort(long[], long);
int main()
{
    long array[100], n, c;
    printf("Enter number of elements: ");
    scanf("%d", &n);
    printf("Enter %d integers: \n", n);
    for(c=0;c<n;c++)
        scanf("%ld", &array[c]);
    bubblesort(array, n);
    printf("Sorted list in ascending order: \n");
    for(c=0;c<n;c++)
        printf("%ld\n", array[c]);
    return 0;
}
void bubblesort(long list[], long n)
{
    long c, d, t;
    for(c=0;c<(n-1);c++)
    {
        for(d=0;d<n-c-1;d++)
        {
            if (list[d]>list[d+1])
            {
                t = list[d];
                list[d]=list[d+1];
                list[d+1]=t;
            }
        }
    }
}
