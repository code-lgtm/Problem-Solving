'''
https://leetcode.com/problems/constrained-subsequence-sum/

Given an integer array nums and an integer k, return the maximum sum of a non-empty subsequence of that array 
such that for every two consecutive integers in the subsequence, nums[i] and nums[j], 
where i < j, the condition j - i <= k is satisfied.

A subsequence of an array is obtained by deleting some number of elements (can be zero) from the array, 
leaving the remaining elements in their original order.

Input: nums = [10,2,-10,5,20], k = 2
Output: 37
Explanation: The subsequence is [10, 2, 5, 20].

Input: nums = [-1,-2,-3], k = 1
Output: -1
Explanation: The subsequence must be non-empty, so we choose the largest number.

Input: nums = [10,-2,-10,-5,20], k = 2
Output: 23
Explanation: The subsequence is [10, -2, -5, 20].

Constraints:

1 <= k <= nums.length <= 10^5
-10^4 <= nums[i] <= 10^4


Solution Approach

Dynamic Programming:
1.  Sub Problem Definition: Maximum sum of non-empty subsequence of array ending at index i where 0 <= i < n
2.  Recurrence Relation: MaxSum(i) = max(nums[i], nums[i]+max(MaxSum[j]) where i is in the range [i-k, i)
3.  Final Step: return max(MaxSum(i))

Time Complexity: O(n2) 
Getting TLE for worst case scenarios

Use a Max Priority Queue:
1. Dynamic programming approach remains the same
2. Instead of iterating for k elements, maintain a max priority queue
3. Recurrence relation would involve popping the max sum obtained for sliding window ending at k. For sum outside sliding window, just pop and ignore them

'''

import heapq

def constrainedSubsetSum(nums, k):
  n = len(nums)
  maxSum = nums[0]
  h = [(-nums[0], 0)]
  maxSum = nums[0]
        
  for i in range(1, n):
    while len(h) and h[0][1] < i-k: heapq.heappop(h)
    s = max(nums[i], nums[i]-h[0][0])
    maxSum = max(maxSum, s)
    heapq.heappush(h, (-s, i))
  return maxSum


def test():
  assert constrainedSubsetSum([10,2, -10, 5, 20], 2) == 37

test()
