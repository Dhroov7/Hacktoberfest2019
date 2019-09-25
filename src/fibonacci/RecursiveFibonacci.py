def fibonacci(n):
  if(n==1 or n==0):
      return n;
  else:
      return fact(n-1)+fact(n-2);
