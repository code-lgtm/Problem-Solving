def numberWays(hats):
  n = len(hats) # Number of people
  nhats = 40
  h2p = [[] for _ in range(nhats+1)]
  mod = 10**9+7

  for i in range(n):
    for hat in hats[i]:
      h2p[hat].append(i)

  dp = [[0 for _ in range( 2**n)] for _ in range(nhats+1)]
  dp[0][0] = 1

  for hat in range(1, nhats+1):
    for s in range(2**n):
      dp[hat][s] += dp[hat-1][s]
      dp[hat][s] %= mod
      
      for p in h2p[hat]:
        if (1<<p)&s != 0:
          dp[hat][s] += dp[hat-1][(1<<p)^s] 
          dp[hat][s] %= mod

  return dp[nhats][2**n-1]

def test():
  assert numberWays([[3,4],[4,5],[5]]) == 1
  assert numberWays([[3,5,1],[3,5]]) == 4
  assert numberWays([[1,2,3,4],[1,2,3,4],[1,2,3,4],[1,2,3,4]]) == 24
  assert numberWays([[1,2,3],[2,3,5,6],[1,3,7,9],[1,8,9],[2,5,7]]) == 111
 

test()
