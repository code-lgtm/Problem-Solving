"""
ID: kumar.g1
LANG: PYTHON2
TASK: Edit Distance
"""

fin = open("edit_distance.in", "r")

N = int(fin.readline().rstrip("\n"))

def diff(A, B, i, j):
  return 0 if A[i]==B[j] else 1

def edit_distance(A, B):
  M = [[0 for _ in range(len(B)+1)] for _ in range(len(A)+1)]
  for i in range(len(A)+1):
    M[i][0] = i
  for j in range(len(B)+1):
    M[0][j] = j

  for i in range(1, len(A)+1):
    for j in range(1, len(B)+1):
      M[i][j] = min(1+M[i-1][j], 1+M[i][j-1], M[i-1][j-1]+diff(A, B, i-1, j-1))
  return M[i][j]

for _ in range(N):
  A = fin.readline().rstrip("\n")
  B = fin.readline().rstrip("\n")
  print edit_distance(A, B)

fin.close()
