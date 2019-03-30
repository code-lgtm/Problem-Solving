"""
ID: kumar.g1
LANG: PYTHON2
TASK: Longest Increasing Subsequence  
"""

def lis(input):
  n = len(input)
  prev = [i for i in range(n)]
  adj = [[] for _ in range(n)]
  L = [1 for _ in range(n)]

  for i in range(n):
    for j in range(i):
      if input[i] > input[j]:
        adj[i].append(j)

  for i in range(n):
    max_index = -1
    max_value = -1
    for j in adj[i]:
      if L[j] > max_value:
        max_value = L[j]
        max_index = j
    
    if max_index >= 0:
      L[i] = 1 + max_value
      prev[i] = max_index

  max_index = -1
  max_value = -1
  for i in range(n):
    if L[i] > max_value:
      max_value = L[i]
      max_index = i

  seq = []
  i = max_index
  while max_value > 0:
    seq.append(input[i])
    max_value -= 1
    i = prev[i]

  seq.reverse()
  return seq
    

def test():
  assert lis([5, 2, 8, 6, 3, 6, 9, 7]) == [2, 3, 6, 9]
  assert lis([5, 7, 4, -3, 9, 1, 10, 4, 5, 8, 9, 3]) == [-3, 1, 4, 5, 8, 9]

test()
    
