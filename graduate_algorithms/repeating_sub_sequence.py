"""
ID: kumar.g1
LANG: PYTHON2
TASK: https://www.interviewbit.com/problems/repeating-subsequence/
"""

def repeating_sequence(A):
  l = [[(False,-1, -1) for _ in range(60)] for _ in range(60)]
  for i, c in enumerate(A):
    row = ord(c)-65
    for j in range(i+1, len(A)):
      col = ord(A[j])-65
      if l[row][col][0] and (l[row][col][1] != i) and (l[row][col][2] != j):
        return 1
      else:
        if not l[row][col][0]:
          l[row][col] = (True, i, j)
  return 0

def repeating_sequence_dp(A):
  n = len(A)
  l = [[0 for _ in range(n+1)] for _ in range(n+1)]
  
  for i in range(1, n+1):
    for j in range(1, n+1):
      if i != j and A[i-1] == A[j-1]:
        l[i][j] = 1 + l[i-1][j-1]
        if l[i][j] > 1:
          return 1
      else:
        l[i][j] = max(l[i-1][j], l[i][j-1])
  return 0
     
    

assert repeating_sequence_dp("abab") == 1
assert repeating_sequence_dp("abba") == 0
assert repeating_sequence_dp("wrBq") == 0
