"""
ID: kumar.g1
LANG: PYTHON2
TASK: https://www.interviewbit.com/problems/distinct-subsequences/
"""

def distinct_sub_sequences(s, t):
  ls = len(s)
  lt = len(t)
  A = [[0 for _ in range(lt+1)] for _ in range(ls+1)]

  for i in range(ls+1):
    A[i][0] = 1

  for i in range(1, ls+1):
    for j in range(1, lt+1):
      if i < j:
        break
      if s[i-1] == t[j-1]:
        A[i][j] = A[i-1][j-1] + A[i-1][j]
      else:
        A[i][j] = A[i-1][j]
  return A[ls][lt]

assert distinct_sub_sequences("rabbbit", "rabbit") == 3
assert distinct_sub_sequences("rrarra", "ra") == 6
