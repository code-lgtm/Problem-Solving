"""
ID: kumar.g1
LANG: PYTHON2
TASK: hamming
"""


fin = open ('hamming.in', 'r')
fout = open ('hamming.out', 'w')
adj = []

N, B, D = map(int, fin.readline().rstrip("\n").split(" "))
M = 2**B

def hamming_distance(a, b):
  distance = 0
  for i in range(B):
    j = 1<<i
    n1 = a&j
    n2 = b&j
    if n1^n2:
      distance += 1
  return (distance >= D)

def gen_map():
  for i in range(M):
    adj.append([])

  for i in range(M):
    for j in range(i+1, M):
      if hamming_distance(i, j):
        adj[i].append(j)
        adj[j].append(i)

gen_map()

def codewords_N():
  rejected = [False] * M
  for i in range(M):
      codewords = []
      visited = [False] * M
      search_codewords(codewords, i, visited, rejected)
      if len(codewords) < N:
        rejected.append(i)
      else:
        nlines = N/10

        j = 0
        for _ in range(nlines):
          for k in range(j, j+9):
            fout.write(str(codewords[k]) + " ")
          fout.write(str(codewords[j+9]))
          fout.write("\n")
          j += 10
        if j < N:
          for k in range(j, N-1):
            fout.write(str(codewords[k]) + " ")
          fout.write(str(codewords[N-1]))
          fout.write("\n")
        break

def search_codewords(codewords, i, visited, rejected):
  if visited[i] or rejected[i]:
    return

  visited[i] = True
  for j in codewords:
    if j not in adj[i]:
      return

  codewords.append(i)

  for j in adj[i]:
    search_codewords(codewords, j, visited, rejected)
    if len(codewords) >= N:
      return

codewords_N()
fout.close()
fin.close()

