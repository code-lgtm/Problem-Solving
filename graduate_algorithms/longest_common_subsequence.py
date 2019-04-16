"""
ID: kumar.g1
LANG: PYTHON2
TASK: Longest Common Subsequence
"""

def longestCommonSubsequence(a, b):
  len_a = len(a)
  len_b = len(b)

  if not len_a or not len_b:
    return 0

  L = [[0 for _ in range(len_b+1)] for _ in range(len_a+1)]

  for i in range(1, len_a+1):
    for j in range(1, len_b+1):
      if a[i-1] == b[j-1]:
        L[i][j] = 1 + L[i-1][j-1]
      else:
          L[i][j] = max(L[i-1][j], L[i][j-1])

  max_len = L[len_a][len_b]
  i = len_a
  j = len_b
  seq = []

  while max_len > 0:
    if L[i][j] == L[i-1][j-1]+1 and  a[i-1] == b[j-1]:
      seq.append(a[i-1])
      max_len -= 1
      i = i-1
      j = j-1
    elif i > 0 and L[i-1][j] == L[i][j]:
      i = i-1
    else:
      j = j-1

  return list(reversed(seq))

# assert longestCommonSubsequence([1, 2, 3, 4, 1], [3, 4, 1, 2, 1, 3]) == [1, 2, 3]
print longestCommonSubsequence([1, 2, 3, 4, 1], [3, 4, 1, 2, 1, 3])


