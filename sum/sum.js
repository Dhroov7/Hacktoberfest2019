/**
 * Calculate sum of numbers.
 * 
 * @param (string) var nums Numbers seperated with comma.
 * 
 * @return int
 */

function sum(nums){
	var answer = 0
	var num = nums.split(',')
	num.forEach(function(num){
		num = Number.parseInt(num)
		answer += num;
    })
	
	return answer
}

console.log(sum("25,25"))