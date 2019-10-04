import calendar


# Leap year Function
def leap_year(year,no_of_years):
    counter = 0
    while counter < no_of_years:
        if calendar.isleap(year):
            print(year)
            counter = counter + 1
        year = year+1   

# Driver Code
leap_year(2020,20)

