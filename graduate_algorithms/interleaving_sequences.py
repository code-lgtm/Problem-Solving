"""
ID: kumar.g1
LANG: PYTHON2
TASK: https://www.interviewbit.com/problems/interleaving-strings/ 
"""

def isequal(s1, s2, i, j):
  if i < 0 or j < 0:
    return False

  return s1[i] == s2[j]


def solution(seq1, seq2, t):
  lseq1 = len(seq1)
  lseq2 = len(seq2)
  lt = len(t)
  
  if lt != lseq1 + lseq2:
    return 0

  arr = [[0 for _ in range(lseq2+1)] for _ in range(lseq1+1)]
  arr[0][0] = 1

  for i in range(lseq1):
    if seq1[i] == t[i]:
      arr[i+1][0] = arr[i][0]

  for j in range(lseq2):
    if seq2[j] == t[j]:
      arr[0][j+1] = arr[0][j]
   
  for i in range(lseq1):
    for j in range(lseq2):
      k = i+j+1
      if seq1[i] == seq2[j] and seq1[i] == t[k]:
        arr[i+1][j+1] = arr[i][j+1] or arr[i+1][j]
      elif seq1[i] == t[k]:
        arr[i+1][j+1] = arr[i][j+1]
      elif seq2[j] == t[k]:
        arr[i+1][j+1] = arr[i+1][j]
      else:
        arr[i+1][j+1] = 0

  return arr[lseq1][lseq2]
    



def recursive_sln(s1, s2, t, i, j, k):
  if (i, j, k) == (-1, -1, -1):
    return 1

  if k < 0:
    return 0

  if isequal(s1, t, i, k) and isequal(s2, t, j, k):
    return recursive_sln(s1, s2, t, i-1, j, k-1) or recursive_sln(s1, s2, t, i, j-1, k-1)
  elif isequal(s1, t, i, k): 
    return recursive_sln(s1, s2, t, i-1, j, k-1)
  elif isequal(s2, t, j, k):
    return recursive_sln(s1, s2, t, i, j-1, k-1)
  return 1

  



assert solution("aabcc", "dbbca", "aadbbcbcac") == 1
assert solution("aabcc", "dbbca", "aadbbbaccc") == 0
assert solution("LgR8D8k7t8KIprKDTQ7aoo7ed6mhKQwWlFxXpyjPkh", "Q7wQk8rqjaH971SqSQJAMgqYyETo4KmlF4ybf", "Q7wLgR8D8Qkk7t88KIrpqjarHKD971SqSQJTQ7aoAMgoq7eYd6yETmhoK4KmlQwWFlF4xybXfpyjPkh") == 1
assert solution("abc", "bdc", "abcbdc") == 1
assert solution("bdc", "abc", "abcbdc") == 1
