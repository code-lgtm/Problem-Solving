"""
ID: kumar.g1
LANG: PYTHON2
TASK: sprime
"""

import itertools
import math

fin = open ('sprime.in', 'r')
fout = open ('sprime.out', 'w')

N = int(fin.readline())

def isprime(x):
    if x == 0 or x == 1:
        return False
    if x == 2:
        return True

    if not x%2:
        return False

    for i in range(3, int(math.ceil(math.sqrt(x)))+1, 2):
         if not x%i:
             return False
    return True

def issuperprime(s, n):
    if not n:
        if isprime(int(s)):
            fout.write(s + "\n")
        return

    if isprime(int(s)):
        for i in [1, 3, 7, 9]:
            s += str(i)
            issuperprime(s, n-1)
            s = s[:-1]

for i in [2, 3, 5, 7]:
    issuperprime(str(i), N-1)
    

fin.close()
fout.close()
