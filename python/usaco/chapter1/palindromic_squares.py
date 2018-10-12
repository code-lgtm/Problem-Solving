"""
ID: kumar.g1
LANG: PYTHON2
TASK: palsquare
"""

fin = open ('palsquare.in', 'r')
fout = open ('palsquare.out', 'w')

c = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ'

def ispalindrome(s):
    return s == s[::-1]

def convert(x, b):
    l = []
    while x >= b:
        r = x%b
        l.append(c[r-10] if r >= 10 else str(r))
        x = x/b
    l.append(c[x-10] if x >= 10 else str(x))
    return ''.join(l[::-1])

N = int(fin.readline())
squares = [convert(x*x, N) for x in range(1, 301)]

for index, item in enumerate(squares):
    if ispalindrome(str(item)):
        fout.write(str(convert(index+1, N)) + " " + str(item) + "\n")
fout.close()
