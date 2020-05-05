'''

Given an array of integers nums and an integer limit, return the size of the longest continuous subarray such that the absolute difference between any two elements is less than or equal to limit.

In case there is no subarray satisfying the given condition return 0.

Example 1:
Input: nums = [8,2,4,7], limit = 4
Output: 2 

Example 2:
Input: nums = [10,1,2,4,7,2], limit = 5
Output: 4 
Explanation: The subarray [2,4,7,2] is the longest since the maximum absolute diff is |2-7| = 5 <= 5.

Input: nums = [4,2,2,2,4,4,2,2], limit = 0
Output: 3

Constraints:

1 <= nums.length <= 10^5
1 <= nums[i] <= 10^9
0 <= limit <= 10^9


Observation:
If difference between max and min elements in an array is less than or equal to limit, difference between any two numbers in the array cannot exceed that limit

Solution Approach:
1. For a sub array which meets problem constraints, keep a track of the maximum and minimum element of the sub array
2. When a new element is added to the array, constraints would be broken if absolute difference between this element and minElem/maxElem is greater than limit
    1. If a constraint is broken because of minimum element, extract it. Afterwards, keep on popping from min and max heaps till the time we have the index that is one greater than extracted minimum element
    2. If a constraint is broken because of maximum element, extract it. Afterwards, keep on popping from min and max heaps till the time we have the index that is one greater than extracted maximum element

Above approach did work but revised modification results in cleaner code
1. Traverse the array
2. Maintain two heaps maxpq and minpq
3. Iterate the array
4. Add tuple contained element value and index in maxpq and minpq
5. While the difference between max element and min element is greater than limit repeat below steps
    1. Get the minimum index+1 of the minimum and maximum elements.
    2. Delete the max and min elements from maxpq and minpq respectively repeatedly till the time they are in the range from minimum index and current element
6.  Calculate the new size of the complaint subarray, if applicable


'''

import heapq

def longestSubarray(nums, limit):
  maxpq = []
  minpq = []
  maxlen, startIndex = 0, 0
        
  for i, num in enumerate(nums):
    heapq.heappush(maxpq, (-num, i))
    heapq.heappush(minpq, (num, i))
            
    while -maxpq[0][0]-minpq[0][0] > limit:
      j = min(maxpq[0][1], minpq[0][1])+1
      while maxpq[0][1] < j: heapq.heappop(maxpq)
      while minpq[0][1] < j: heapq.heappop(minpq)
      startIndex = j            
    maxlen = max(i-startIndex+1, maxlen)
  return maxlen

def test():
  assert longestSubarray([8,2,4,7], 4) == 2
  assert longestSubarray([10,1,2,4,7,2], 5) == 4
  assert longestSubarray([4,2,2,2,4,4,2,2], 0) == 3

test()





