"""
ID: kumar.g1
LANG: PYTHON2
TASK: pprime
"""

import math
import re
import itertools

fin = open ('pprime.in', 'r')
fout = open ('pprime.out', 'w')

a, b = fin.readline().rstrip("\n").split(" ")

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

def gen_combinations(d):
    for x in itertools.product('0123456789', repeat=d):
        s = ''.join(x)
        if not re.search(r'\b0[0-9]*', s):
            yield s

min_l = len(a)
max_l = 8 if len(b) == 9 else len(b) 
a = int(a)
b = int(b)

for d in range(min_l, max_l+1):
   if d == 1:
       for x in [5, 7]:
           if x >= a and x <= b:
               fout.write(str(x)+"\n")
   else:
       for x in gen_combinations(d/2):
           num = 0
           if d%2:
               for i in range(10):
                   num = int(x + str(i) + x[::-1])
                   if num >=a and num <=b and isprime(num):
                       fout.write(str(num)+"\n")
           else:
               num = int(x + x[::-1])
               if num >=a and num <=b and isprime(num):
                   fout.write(str(num)+"\n")

fout.close()
fin.close()
 


