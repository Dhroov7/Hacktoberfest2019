#To check whether a number is Lab Number or not
def checkLab(n):
    if n==2:
        return False
    else:

        list1=[]
        for i in range(2, n//2):
            if n % i ==0:
                list1.append(i)
                list1.append(n/i)

        for i in list1:
            if i** 2 in list1:
                return True
        return False


num = int(input("Enter a number:"))
print(checkLab(num))
