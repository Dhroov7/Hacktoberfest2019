function fibonacci(n) {
    if (n==0 || n==1) {
        return n;
    }
    return fibonacci(n-1) + fibonacci(n-2);
}

let n = 8;
console.log(fibonacci(n));