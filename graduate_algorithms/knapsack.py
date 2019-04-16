"""
ID: kumar.g1
LANG: PYTHON2
TASK: Knapsack
"""

def knapsack_with_repetition(k, arr):
  l = [0] * (k+1)
  for i in range(1, k+1):
    l[i] = max([l[i-w]+w if i-w >=0 else 0 for w in arr])
  return l[k]

print knapsack_with_repetition(9, [3, 4, 4, 4, 8])
