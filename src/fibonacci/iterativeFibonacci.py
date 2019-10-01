
def iterativefib(n):
	if n <= 2:
		return 1
	a, b = 1, 1
	for i in range(n-2):
		b,a = a, a+b
	return a

if __name__ == "__main__":
	
	print(iterativefib(10)) #55
