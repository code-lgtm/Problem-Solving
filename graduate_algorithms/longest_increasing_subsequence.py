"""
ID: kumar.g1
LANG: PYTHON2
TASK: Longest Increasing Subsequence  
"""

fin = open ('lis.txt', 'r')

N = int(fin.readline().rstrip("\n"))
l = []

for _ in range(N):
  l.append(int(fin.readline().rstrip("\n")))


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

def bin_srch(input, start, end, index, num, seq_indexes, prev):
  while start <= end:
    if start == end:
      if input[seq_indexes[start]] >= num:
        seq_indexes[start] = index
        if start > 0:
          prev[index] = seq_indexes[start-1]
      return

    mid = (start+end)/2
    mid_val = input[seq_indexes[mid]] 
    if mid_val < num:
      start = mid+1
    else:
      end = mid

def lis_optimized(input):
  n = len(input)
  max_length = 0
  prev = [-1 for _ in range(n)]
  seq_indexes = [-1 for _ in range(n)]
  seq_indexes[0] = 0

  for i, num in enumerate(input):
    if not i:
      continue
    if num > input[seq_indexes[max_length]]:
      max_length += 1
      seq_indexes[max_length] = i
      prev[i] = seq_indexes[max_length-1]
    else:
      bin_srch(input, 0, max_length, i, num, seq_indexes, prev)

  seq = []
  i = seq_indexes[max_length]
  while i >= 0:
    seq.append(input[i])
    i = prev[i]

  seq.reverse()
  return seq
    

def test():
  assert lis_optimized([5, 2, 8, 6, 3, 6, 9, 7]) == [2, 3, 6, 7]
  assert lis_optimized([5, 7, 4, -3, 9, 1, 10, 4, 5, 8, 9, 3]) == [-3, 1, 4, 5, 8, 9]
  print  len(lis_optimized(l))
  assert lis_optimized([1, 1, 1, 1]) == [1]

test()
