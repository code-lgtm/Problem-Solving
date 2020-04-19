'''

Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.

Example:

Input:
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]

Output: 7

Explanation: Because the path 1-3-1-1-1 minimizes the sum.

'''


def minPathSum(grid):
  if not len(grid) : return 0
  m, n = len(grid), len(grid[0])
  S = grid
        
  for i in range(1, m): S[i][0] = S[i-1][0] + grid[i][0]
  for j in range(1, n): S[0][j] = S[0][j-1] + grid[0][j]
        
  for i in range(1, m):
    for j in range(1, n):
      S[i][j] = grid[i][j] + min(S[i-1][j], S[i][j-1])
        
  return S[-1][-1]

def test():
  assert minPathSum([[1, 3, 1], [1, 5, 1], [4, 2, 1]]) == 7

test()
