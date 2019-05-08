"""
ID: kumar.g1
LANG: PYTHON2
TASK: https://www.interviewbit.com/problems/tushars-birthday-party/
"""

def solve(A, B, C):
  min_cost = 0
  e = max(A)
  k = [0] * (e+1)

  for i in range(1, e+1):
    k[i] = min([k[i-f]+C[index] for index, f in enumerate(B) if f <= i])

  for e in A:
    min_cost += k[e]
  return min_cost


print solve([4, 6], [1,3], [5,3])
