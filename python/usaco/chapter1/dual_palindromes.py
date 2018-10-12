
"""
ID: kumar.g1
LANG: PYTHON2
TASK: dualpal 
"""

fin = open ('dualpal.in', 'r')
fout = open ('dualpal.out', 'w')


N,S = fin.readline().rstrip("\n").split(" ")

def ispalindrome(s):
    if s[0] == '0' or s[len(s)-1] == '0':
        return False
    return s == s[::-1]

def convert(x, b):
    l = []
    while x >= b:
        r = x%b
        l.append(c[r-10] if r >= 10 else str(r))
        x = x/b
    l.append(c[x-10] if x >= 10 else str(x))
    return ''.join(l[::-1])

count = 0

x = int(S)
while count < int(N):
    x = x+1
    num_palindromes = 0
    for b in range(2, 11):
        if ispalindrome(convert(x, b)):
            num_palindromes += 1
            if num_palindromes > 1:
                fout.write(str(x) + "\n")
                count +=1
                break
fout.close()      
