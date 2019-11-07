numbers=input("Please write the numbers you want to add up:\n")
pack=numbers.split(" ")
def sum(pack):
    sum=0
    for i in pack:
        sum += int(i)
    print(f"The sum of your numbers is {sum}")
    
sum(pack)