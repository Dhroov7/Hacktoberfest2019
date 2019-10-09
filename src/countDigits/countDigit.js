function countDigit(number){
    if(number = 0)
        return 0;
    else
        return 1 + countDigit(number/10)
}

var number = 345289467;
console.log("Number of digits :", countDigit(number));