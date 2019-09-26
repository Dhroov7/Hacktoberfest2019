def checkPalindrome(string_text):
    return string_text[::-1] == string_text

if __name__ == "__main__":
    s1 = 'racecar'
    s2 = 'abccba'
    s3 = 'acbac'

    print(s1, 'is' if checkPalindrome(s1) else 'isn\'t', 'a Palindrome String')
    print(s2, 'is' if checkPalindrome(s2) else 'isn\'t', 'a Palindrome String')
    print(s3, 'is' if checkPalindrome(s3) else 'isn\'t', 'a Palindrome String')

# Output
# racecar is a Palindrome String
# abccba is a Palindrome String
# acbac isn't a Palindrome String