"""
ID: kumar.g1
LANG: PYTHON2
TASK: Longest Common Subsequence
"""

def longestCommonSubsequence(a, b):
  L = [[(0, 0, 0) for _ in range(len(b)+1)] for _ in range(len(a)+1)]

  for i in range(1, len(a)+1):
    for j in range(1, len(b)+1):
      if a[i-1] == b[j-1]:
        L[i][j] = (1 + L[i-1][j-1], i-1, j-1)
      else:
        if L[i-1][j] > L[i][j-1]:
          L[i][j] = (L[i-1][j], i-1, j)
        else:
          L[i][j] = (L[i][j-1], i, j-1)

  return L[len(a)][len(b)]



# assert longestCommonSubsequence([1, 2, 3, 4, 1], [3, 4, 1, 2, 1, 3]) == [1, 2, 3]
print longestCommonSubsequence([1, 2, 3, 4, 1], [3, 4, 1, 2, 1, 3])


