"""
ID: kumar.g1
LANG: PYTHON2
TASK: 6.4 (Dasgupta-Papadimitriou-Vazirani)
"""

l = ["it", "was", "the", "best", "of", "times", "hello", "how", "are", "you", "he"]

def wordBreak(A, B):
  len_A = len(A)
  l = []

  for i in range(0, len_A):
    if A[0:i+1] in B:
      l.append(i)
      continue
    for j in reversed(l):
      if A[j+1:i+1] in B:
        l.append(i)
        break
  return 1 if len_A-1 in l else 0

assert wordBreak("itwas", l) == 1
assert wordBreak("itwasthebestoftimes", l) == 1
assert wordBreak("hellohowareyou", l) == 1
assert wordBreak("hellohowareye", l) == 0



