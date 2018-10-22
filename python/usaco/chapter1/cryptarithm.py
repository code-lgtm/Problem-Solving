"""
ID: kumar.g1
LANG: PYTHON2
TASK: crypt1
"""

import itertools


fin = open ('crypt1.in', 'r')
fout = open ('crypt1.out', 'w')

fin.readline()
input_digits = ''.join(fin.readline().rstrip("\n").split(" "))

def isValid(n, digits, valid_length):
    sn = str(n)
    if len(sn) != valid_length:
        return False
    for i in sn:
        if i not in digits:
            return False
    return True

nsolutions = 0

for ta in itertools.product(input_digits, repeat=3):
    for tb in itertools.product(input_digits, repeat=2):
        a = ''.join(ta)
        b = ''.join(tb)
        partial_product_1 = int(a) * int(b[1])
        if not isValid(partial_product_1, input_digits, 3):
            continue
        partial_product_2 = int(a) * int(b[0])
        if not isValid(partial_product_2, input_digits, 3):
            continue
        soln = partial_product_1 + 10 * partial_product_2
        if not isValid(soln, input_digits, 4):
            continue
        nsolutions += 1

fout.write(str(nsolutions) + "\n")
fout.close()
