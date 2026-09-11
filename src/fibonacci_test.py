#!/usr/bin/env python3
"""
Print the first 10 Fibonacci numbers.
Run: python3 src/fibonacci_test.py
"""

def first_n_fibonacci(n: int):
    """Generate the first n Fibonacci numbers, starting with 0, 1."""
    if n <= 0:
        return []
    fibs = []
    a, b = 0, 1
    while len(fibs) < n:
        fibs.append(a)
        a, b = b, a + b
    return fibs

if __name__ == "__main__":
    nums = first_n_fibonacci(10)
    # Print as a single line of space-separated numbers followed by a newline.
    print(" ".join(map(str, nums)))
