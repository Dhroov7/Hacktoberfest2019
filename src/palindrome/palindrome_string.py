# Program to check whether a string is palindrome

def checkPalindrome(s: str)->bool:
    return s == s[::-1]

assert(checkPalindrome('radar')==True)
assert(checkPalindrome('rader')==False)

