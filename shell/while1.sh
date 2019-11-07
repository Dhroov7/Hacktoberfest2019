#!/bin/bash
read -p "enter a number " a
count=1
while [ $count -le $a ]
do
	
	echo $count
	count=$((count+1))
done
