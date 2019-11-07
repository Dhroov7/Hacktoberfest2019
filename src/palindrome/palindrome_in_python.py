# Palindrome checker
def main():
    print("Palindrome Checker")
    word = input("Please enter a word: ")
    is_palindrome(word)


# Check if the word is a palindrome
def is_palindrome(word):
    if word.upper() == word[::-1].upper():
        print(f"{word.capitalize()} is a palindrome.")
    else:
        print(f"{word.capitalize()} is not a palindrome.")


main()
