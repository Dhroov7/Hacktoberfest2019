import strutils

proc reverse(s: string): string =
  result = newString(s.len)
  for i,c in s:
    result[s.high - i] = c

proc isPalindrome(s: string): bool =
  s == reverse(s)

echo "Enter the word to test here: "
var word: string = readLine(stdin)
echo isPalindrome(word)
