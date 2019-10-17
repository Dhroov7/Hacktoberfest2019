#include <stdio.h>
#include <stdlib.h>
#define true  1
#define false 0

void printPrimeFactors(int);
_Bool checkPrime(int);

int main(int argc, char *argv[]){
	/* 
	 * Prints the factor of a given int on the stdout
	 * arguments are to be passed via CLI
	 * 
	 */

	if(argc == 1){
		printf("error: no input\n");
		return 1;
	} else {
		for(int i=1; i < argc; ++i){
			int temp = atoi(argv[i]);
			if(temp <= 32767)
				printPrimeFactors(atoi(argv[i]));
			else
				return 1;
		}
		return 0;
	}

}

void printPrimeFactors(int n){
	for(int i=2; i < n/2 + 1; ++i){
		if((n % i == 0) && checkPrime(i) == true)
			printf("%d ", i);
	}
	if(checkPrime(n) == true)
		printf("%d ", n);
	printf("\n");
}

_Bool checkPrime(int n){
	for(int i=2; i < n/2 + 1; ++i){
		if(n % i == 0)
			return false;
	}
	return true;
}
