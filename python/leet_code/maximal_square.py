'''
https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/531/week-4/3312/

Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

Input: 

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0

Output: 4


Step1: Defining Subproblem
dp(i,j) represents the side length of the maximum square whose bottom right corner is the cell with index (i,j) in the original matrix

Step2: Define recurrence relation
dp(i,j)=min(dp(i−1,j),dp(i−1,j−1),dp(i,j−1))+1

'''

def maximalSquare(matrix):
  if not matrix : return 0 
        
  m,n = len(matrix), len(matrix[0])
  max_square = 0
  dp = [[0]*(n+1) for _ in range(m+1)]        
  for i in range(1, m+1):
    for j in range(1, n+1):
      if matrix[i-1][j-1]:
        dp[i][j] =  min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1])+1
        max_square = max(max_square, dp[i][j])
  return max_square**2


def test():
  assert maximalSquare([[1, 0, 1, 0, 0], [1, 0, 1, 1, 1], [1, 1, 1, 1, 1], [1, 0, 0, 1, 0]]) == 4

test()

