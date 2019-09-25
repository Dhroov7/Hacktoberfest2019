def fibonacci(n):
  if(n==1 or n==0):
      return n;
  else:
      return fibonacci(n-1)+fibonacci(n-2);
n = int(input('Enter a number to find nth fibonacci number:'))
print(fibonacci(n))

