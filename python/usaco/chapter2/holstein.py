"""
ID: kumar.g1
LANG: PYTHON2
TASK: holstein 
"""

import itertools

fin = open ('holstein.in', 'r')
fout = open ('holstein.out', 'w')

V = int(fin.readline().rstrip("\n"))
reqmt = map(int, fin.readline().rstrip("\n").split(" "))
G = int(fin.readline().rstrip("\n"))
feeds = []
for _ in range(G):
  feeds.append(map(int, fin.readline().rstrip("\n").split(" ")))

def feed_combinations():
  indexes = range(G)
  for i in range(1, G+1):
    yield itertools.combinations(indexes, i)

def valid_combination(possible_sln):
  for v in range(V):
    if reqmt[v] > possible_sln[v]:
      return False
  return True

def print_sln(c):
  fout.write(str(len(c)) + " ")
  for i in range(len(c)-1):
    fout.write(str(c[i]+1) + " ")
  fout.write(str(c[len(c)-1]+1) + "\n")

found = False

for combination in feed_combinations():
  if found:
    break
  for c in combination:
    possible_sln = []
    for v in range(V):
      possible_sln.append(sum([feeds[i][v] for i in c]))
    if valid_combination(possible_sln):
      print_sln(c)
      found = True
      break

fin.close()
fout.close()
