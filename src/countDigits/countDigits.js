function countDigits(n) {
    if (n == 0) {
        return 0;
    }
    return (1 + countDigits(Math.floor(n/10)));
}

var n = 2324234;
console.log(countDigits(n));