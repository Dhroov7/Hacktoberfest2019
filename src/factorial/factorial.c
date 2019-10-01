//Code contributed by Yogesh Singh
#include<stdio.h>

int fact(int num) {
    if(num == 1)
        return 1;
    else 
        return num*fact(num-1);
}

int main() {
    int input;
    printf("Enter the number to find the factorial: ");
    scanf("%d", &input);
    printf("Factorial: %d", fact(input));
    return 0;
}