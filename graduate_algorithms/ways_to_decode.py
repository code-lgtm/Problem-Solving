"""
ID: kumar.g1
LANG: PYTHON2
TASK: https://www.interviewbit.com/problems/ways-to-decode/
"""

def numDecodings(A):
  n = len(A)
  L = [0] * (n+1)
  L[0] = 1
        
  for i in range(1, n+1):
    if A[i-1] != '0':
      L[i] += L[i-1]
            
    if i>1 and '10'<=A[i-2:i]<='26':
      L[i] += L[i-2]
                
  return L[n]

assert numDecodings('2611055971756562') == 4
