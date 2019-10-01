num = int(input("Please input, your number: \n"))

def fact(num):
    if num == 1:
        return 1
    else:
        return num * fact(num-1)
    
print(fact(num))