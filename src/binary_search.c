#include<stdio.h>
void main()
{
	int arr[50],size;
	int i,num,flag=0,pos=0;
	printf("ENTER THE SIZE OF ARRAY");
	scanf("%d",&size);
	for(i=0;i<size;i++)
	{
		printf("ENTER %d ARRAY ELEMENT",i+1);
		scanf("%d",&arr[i]);
	}
	printf("ENTER THE NUMBER TO BE SEARCHED");
	scanf("%d",&num);
	for(i=0;i<size;i++)
	{
		if(num==arr[i])
		{
			pos=i+1;
			flag=1;
			break;
		}
	}
	if(flag==1)
		printf("NUMBER FOUND AT %d POSTION",pos);
	else
		printf("NUMBER NOT FOUND");


}
