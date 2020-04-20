'''
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.

Your algorithm's runtime complexity must be in the order of O(log n).
'''

def findPivot(nums, start, end):
  if start > end: return -1
        
  n = len(nums)-1
  mid = (start+end)//2
  # Is this the place wherr rotation is happening.
  if (nums[mid-1] > nums[mid]) and (nums[mid] < nums[(mid+1)%n]): return mid
      
  # Check right half if number is greater than first element. Otherwise go left
  if nums[mid] >= nums[0]: return self.findPivot(nums, mid+1, end)
  else: return self.findPivot(nums, 0, mid-1)
        
def bin_search(nums, start, end, target):
  if start > end: return -1
  mid = (start+end)//2
        
  if nums[mid] == target: return mid
  elif target < nums[mid]: return bin_search(nums, start, mid-1, target)
  else: return bin_search(nums, mid+1, end, target)
 
    
def search(nums, target):
  if len(nums) == 0: return -1
  n = len(nums)-1
        
  # Input array is already sorted. Do a simple binary search
  if nums[0] <= nums[-1]: return self.bin_search(nums, 0, n, target) 
  pivot = self.findPivot(nums, 0, len(nums)-1)
        
  # Search in left or right sorted array depending on value of target wrt first or last element
  if target == nums[pivot]: return pivot
  elif target > nums[-1]: return self.bin_search(nums, 0, pivot-1, target)
  else: return self.bin_search(nums, pivot+1, n, target)



def test():
  assert search([0, 1, 2, 4, 5, 6, 7], 0) == 0
  assert search([5, 6, 7, 0, 1, 2, 4], 0) == 3
  assert search([6, 7, 0, 1, 2, 4], 0) == 2
  assert search([7, 0, 1, 2, 4], 0) == 1
  assert search([7, 0, 1, 2, 4], 5) == -1
  assert search([3, 1], 3) == 0
  assert search([1, 3], 1) == 0
