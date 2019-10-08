#include <stdio.h>
#include <time.h>
#include <stdbool.h>

#define NUMLEAPYEARS 20

bool isLeapYear(int year);

void main() {
	int leapyears[NUMLEAPYEARS];
	time_t now;
	now = time(NULL);
	struct tm *time_now = localtime(&now);
	int this_year = time_now->tm_year + 1900;

	int i = 0;
	while (i < NUMLEAPYEARS) {
		if (isLeapYear(this_year)) {
			leapyears[i] = this_year;
			i++;
		}
		this_year++;
	}
 
	printf("The next 20 leap years are:\n");
	for(i = 0; i < NUMLEAPYEARS; i++) {
		printf("%d\n", leapyears[i]);
	}
}

bool isLeapYear(int year) {
	return (year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0));
}
