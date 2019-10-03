def length(a):
    count=0
    for i in a:
        count=count+1
    return count
def reverse(string):
    rev=""
    string=string.lower()
    for i in range((length(string))-1,-1,-1):
        rev+=string[i];
    return string,rev
def is_palindrome(string,rev):
    count=0
    for i in range(0,length(string)):
        if string[i]!=rev[i]:
            print "The string is not a palindrome!"
            count=1
            break
    if count==0:
        print "The string is a palindrome!"
def main():
    string=raw_input("Enter the string to be checked for palindrome: ")
    string,rev=reverse(string)
    is_palindrome(string,rev)
main()
