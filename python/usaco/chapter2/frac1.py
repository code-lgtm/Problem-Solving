"""
ID: kumar.g1
LANG: PYTHON2
TASK:frac1 
"""

fin = open('frac1.in', 'r')
fout = open('frac1.out', 'w')

N  = int(fin.readline().rstrip("\n"))

def gcd(a, b):
  if not b:
    return a
  return gcd(b, a%b)

l = {}

for i in range(1, N):
  l[i] = []

for i in range(1, N):
  sl = []
  for j in range(i+1, N+1):
    factor = gcd(i, j)
    if factor > 1:
      a = i/factor
      b = j/factor
      if b in l[a]:
        continue
    sl.append(j)
  l[i] = sl

output = []
for i in l:
  for j in l[i]:
    output.append(str(i) + "/" + str(j))

output.sort(key = lambda num: eval((num+".0")))


fout.write("0/1" + "\n")
for entry in output:
  fout.write(entry + "\n")
fout.write("1/1" + "\n")

fin.close()
fout.close()

