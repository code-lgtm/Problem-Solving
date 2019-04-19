"""
ID: kumar.g1
LANG: PYTHON2
TASK: Interview Bit Problem - https://www.interviewbit.com/problems/largest-area-of-rectangle-with-permutations/
"""

def solve(A):
  m = len(A)
  n = len(A[0])

  for i in range(1, m):
    for j in range(n):
      A[i][j] = A[i-1][j]+1 if A[i][j]==1 else 0

  max_area = 0
  for i in range(m):
    h_max = max([A[i][j] for j in range(n)])
    l = [0]*(h_max+1)
    for j in range(n):
      l[A[i][j]] += 1
    
    j = 0
    for index, value in enumerate(l):
      while value > 0:
        A[i][j] = index
        value -= 1
        j += 1

    area = A[i][0] * n
    max_area = max(area, max_area)
    for j in range(1, n):
      if A[i][j] != A[i][j-1]:
        area = (n-j)*A[i][j]
        max_area = max(area, max_area)
  return max_area

print solve([[1, 0, 1], [0, 1, 0], [1, 0, 0]])
