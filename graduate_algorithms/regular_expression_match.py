"""
ID: kumar.g1
LANG: PYTHON2
TASK: https://www.interviewbit.com/problems/regular-expression-match/
"""

def isMatch(A, B):
  s = B[0]

  for i in range(1, len(B)):
    if B[i] == B[i-1] and B[i] == '*':
      continue
    else:
      s += B[i]

  B = s

  m = len(A)
  n = len(B)

  if m==0 or n==0:
    return 0

  arr = [[0 for _ in range(n+1)] for _ in range(m+1)]
  arr[0][0] = 1

  for j in range(1, n+1):
    if B[j-1] == "*":
      arr[0][j] = arr[0][j-1]
      if not arr[0][j]:
        break

  for i in range(1, m+1):
    for j in range(1, n+1):
      if B[j-1] == "*":
        arr[i][j] = arr[i-1][j] or arr[i][j-1]
      elif B[j-1] == '?' or A[i-1] == B[j-1]:
        arr[i][j] = arr[i-1][j-1]

  return arr[m][n]
     

assert isMatch("aa","a") == 0
assert isMatch("aa","aa") == 1
assert isMatch("aaa","aa") == 0
assert isMatch("aa", "*") == 1
assert isMatch("aa", "a*") == 1
assert isMatch("ab", "?*") ==  1
assert isMatch("aab", "c*a*b") == 0
