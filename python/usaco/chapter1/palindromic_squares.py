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
        if r >= 10:
            l.append(c[r-10])
        else:
            l.append(str(x%b))
        x = x/b
    if x >= 10:
        l.append(c[x-10])
    else:
        l.append(str(x))
    return ''.join(l[::-1])

squares = [i*i for i in range(1, 301)]


N = int(fin.readline())

if N != 10:
    squares = [convert(x, N) for x in squares]

for index, item in enumerate(squares):
    if ispalindrome(str(item)):
        fout.write(str(convert(index+1, N)) + " " + str(item) + "\n")
