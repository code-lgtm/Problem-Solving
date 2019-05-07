"""
ID: kumar.g1
LANG: PYTHON2
TASK: https://www.interviewbit.com/problems/n-digit-numbers-with-digit-sum-s-/ 
"""

def solve(A, B):
  M = 1000000007
  D = [[0 for _ in range(B+1)] for _ in range(A+1)]

  for i in range(1, 10):
    if i <= B:
      D[1][i] = 1

  for i in range(2, A+1):
    for k in range(1, B+1):
      D[i][k] = (D[i][k] + D[i-1][k]) % M
      for j in range(1, 10):
        if k+j <= B:
          D[i][k+j] = (D[i][k+j] + D[i-1][k]) % M

  return D[A][B]

assert solve(75, 22) == 478432066
assert solve(2, 4) == 4
assert solve(3, 4) == 10
