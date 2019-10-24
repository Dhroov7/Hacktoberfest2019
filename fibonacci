def fibonacci(n):  
      
    # Taking 1st two fibonacci nubers as 0 and 1  
    FibArray = [0, 1]  
      
    while len(FibArray) < n + 1:  
        FibArray.append(0)  
      
    if n <= 1:  
        return n  
    else:  
        if FibArray[n - 1] == 0:  
            FibArray[n - 1] = fibonacci(n - 1)  
  
        if FibArray[n - 2] == 0:  
            FibArray[n - 2] = fibonacci(n - 2)  
              
    FibArray[n] = FibArray[n - 2] + FibArray[n - 1]  
    return FibArray[n]  
      
print(fibonacci(9))  
