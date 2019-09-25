def sumOfDigits(n):
  """
  Recursive sum of digits
  """
  n = abs(n)
  if n < 10:
    return n
  else:
    return n%10 + sumOfDigits(n//10)

assert(sumOfDigits(1234)==10)
assert(sumOfDigits(1)==1)
assert(sumOfDigits(-123)==6)

# Added by @amitrajitbose

