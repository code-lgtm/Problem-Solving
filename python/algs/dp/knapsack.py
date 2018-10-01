'''
https://www.hackerrank.com/challenges/unbounded-knapsack/problem`
'''

def unboundedKnapsack(k, arr):
   arr = sorted(arr)
   a = [False for _ in range(k+1)] 
   a[0] = True

   max_sum = 0

   for rsum in range(1, k+1):
       for item in arr:
           if (rsum-item >= 0) and a[rsum-item]:
               a[rsum] = True
               max_sum = rsum
               continue
   return max_sum
               
   
