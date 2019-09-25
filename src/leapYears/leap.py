year = 2019
leapYears = []

while len(leapYears) != 20:
    if year % 4 == 0 or (year % 100 == 0 and year % 400 == 0): 
        leapYears.append(year)
    else:
        pass
    year+=1

print(leapYears)
