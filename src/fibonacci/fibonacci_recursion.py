def FibonacciSeries(n):
  """
  Prints the first n elements of the Fibonacci Series
  """
  if n < 1:
    print("")
  else:
    for i in range(n):
      print(Fibonacci(i), end=" ")
    print("")

def Fibonacci(n):
  """
  Returns the nth term of the Fibonacci Sequence
  n is zero based indexed
  """
  if n < 0:
    raise Exception("Invalid Argument")
  elif n < 2:
    return n
  else:
    return Fibonacci(n-1) + Fibonacci(n-2)

#Call the method as shown below, uncomment by removing the '#'
#FibonacciSeries(10)

#Added By @amitrajitbose
