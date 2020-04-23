'''
Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.

Example 1:
Input:nums = [1,1,1], k = 2
Output: 2
'''

from collections import defaultdict

def subarraySum(nums, k):
  # When a key is first encountered, 
  # it is missing from the mapping, 
  # so the default_factory function calls 
  # int() to supply a default count of zero
  prevSum = defaultdict(int)

  currentSum = 0
  cnt = 0
  for num in nums:
    currentSum += num
    if currentSum == k:
      cnt += 1
    # currsum exceeds given sum by currsum  - sum. 
    # Find number of subarrays having   
    # this sum and exclude those subarrays  
    # from currsum by increasing count by   
    # same amount.
    if currentSum-k in prevSum:
      cnt += prevSum[currentSum-k]
    prevSum[currentSum] += 1
  return cnt
 
def test():
  assert subarraySum([1, 1, 1], 2) == 2

test() 
