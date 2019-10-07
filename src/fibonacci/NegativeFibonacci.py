def fib(n):
    if n < 0:
        return fibNega(n);
    return _fib(n)[0]


def fibNega(n, x=[0, 1]):
    for i in range(abs(n) - 1): x = [x[1], sum(x)]
    return x[1] * pow(-1, abs(n) - 1) if n < 0 else x[1] if n else 0


# Returns the tuple (F(n), F(n+1)).
def _fib(n):
    if n == 0:
        return (0, 1)
    else:
        a, b = _fib(n // 2)
        c = a * (b * 2 - a)
        d = a * a + b * b
        if n % 2 == 0:
            return c, d
        else:
            return d, c + d

# For tests

#print (fib(0))
#print (fib(1))
#print (fib(2))
#print (fib(3))
#print (fib(-4000))
#print (fib(1250000))
