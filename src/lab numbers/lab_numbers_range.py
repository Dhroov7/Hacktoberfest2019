#Find Lab Numbers in a range
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

def printLabnumbers(n1,n2):
    for i in range(n1, n2+1):
        if checkLab(i)==True:
            print(i, end=" ")
        else:
            pass


n1 = int(input("Enter the lower value:"))
n2 = int(input("Enter the upper value:"))

printLabnumbers(n1,n2)
