def reverse(word):
	return word[::-1]

def isaPalindrome(word):
	rev=reverse(word)
	
	if (word==rev):
		return word + " Is A Palindrome"
	else:
		return word + " Is Not A Palindrome"


w=input("Enter a word to check if it's a Palindrome")
isaPalindrome(w)