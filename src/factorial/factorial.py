"""
Written by Arseny Poga

Short function that computes factorial recursively
"""

def factorial(num):
    if num == 1:
        return 1
    else:
        return num * factorial(num-1)


if __name__ == "__main__":
    x = factorial(20)
    print(x)