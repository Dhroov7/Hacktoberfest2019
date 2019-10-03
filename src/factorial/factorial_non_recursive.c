#include<stdio.h>

int main() {
    int input;
    scanf("%d", &input);
    long fact = 1;
    for(int i = 1; i <= input; i++ ) {
        fact *= i;
    }
    printf("%ld", fact);
    return 0;
}