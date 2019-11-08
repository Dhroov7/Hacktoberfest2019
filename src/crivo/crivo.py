def crivo(n):
    c = [True]
    c = c * n + c

    i = 2
    while(i*i <= n):
        if(c[i]):
            j = i
            while(i * j <= n):
                c[i*j] = False
                j += 1
        i += 1
    return c

def showC(c):
    for i in range(2, len(c)):
        if(c[i]):
            print(i)

d = int(input())
c = crivo(d)
showC(c)