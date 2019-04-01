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

def bin_srch(arr, l, r, seq_indexes, key, incr=True):
  cmpfunc = max if incr else min

  while r-l:
    mid = (l+r)/2
    mid_val = arr[seq_indexes[mid]]
    
    if key==mid_val:
       r = mid
       break
    elif cmpfunc(key, mid_val) == key:
      l = mid+1
    else:
      r = mid
  return r

def lis_optimized(arr):
  n = len(arr)
  max_length = 0
  prev = [-1 for _ in range(n)]
  seq_indexes = [-1 for _ in range(n)]

  for i, num in enumerate(arr):
    if num > arr[seq_indexes[max_length]]:
      max_length += 1
      seq_indexes[max_length] = i
      prev[i] = seq_indexes[max_length-1]
    else:
      r = bin_srch(arr, 0, max_length, seq_indexes, num)
      seq_indexes[r] = i
      if r:
        prev[i] = seq_indexes[r-1]

  seq = []
  i = seq_indexes[max_length]
  while i >= 0:
    seq.append(arr[i])
    i = prev[i]

  seq.reverse()
  return seq

def test():
  assert lis_optimized([5, 2, 8, 6, 3, 6, 9, 7]) == [2, 3, 6, 7]
  assert lis_optimized([5, 7, 4, -3, 9, 1, 10, 4, 5, 8, 9, 3]) == [-3, 1, 4, 5, 8, 9]
  print  len(lis_optimized(l))
  assert lis_optimized([1, 1, 1, 1]) == [1]

test()
