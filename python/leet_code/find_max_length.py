# Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.

def findMaxLength(nums):
  n = len(nums)
  if n==0 or n==1: return 0
        
  m = {}
  sum, max_len = 0, 0
  for i in range(n):
    sum = sum+1 if nums[i] else sum-1
    if not sum: max_len = i+1
    elif sum in m: max_len = max(max_len, i-m[sum])
    else: m[sum] = i
  return max_len


def test():
  assert findMaxLength([1, 1, 1, 1, 0, 0, 0, 1]) == 6

test()

