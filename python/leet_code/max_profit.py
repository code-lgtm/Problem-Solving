def maxProfit(prices, left, right):
  profit = 0
  for i in range(left, right+1):
    for j in range(i+1, right+1):
      if prices[j] > prices[i]:
        profit = max(profit, prices[j]-prices[i]+maxProfit(prices, j+1, right))
  return profit


def maxProfit_On(prices):
  return sum([max(prices[i]-prices[i-1], 0) for i in range(1, len(prices))])
    

print(maxProfit_On([7,1,5,3,6,4]))
