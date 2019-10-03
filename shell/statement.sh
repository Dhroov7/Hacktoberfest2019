#!/bin/bash
echo "Enter  a number "
read a
if [ $a -eq 10 ]
then
	echo "You entered the value 10"
elif [ $a -gt 10 ]
then 
	echo "your number is greater than 10 "
else
	echo "your number is less than 10 "
fi
