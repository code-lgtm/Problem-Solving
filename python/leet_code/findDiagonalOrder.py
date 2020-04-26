'''

https://leetcode.com/problems/diagonal-traverse-ii/

Given a list of lists of integers, nums, return all elements of nums in diagonal order as shown in the below images.

Input: nums = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,4,2,7,5,3,8,6,9]


Key Idea : Key idea here is that in a 2D matrix elements in the same diagonal have same sum of their indices. So if we have all elements with same sum of their indices together, then it’s just a matter of printing those elements in order.

'''

from collections import defaultdict

def findDiagonalOrder(nums):
  diag = defaultdict(list) 
  for i in range(len(nums)):
    for j in range(len(nums[i])):
      diag[i+j].append(nums[i][j])
        
  output = []
  for key in sorted(diag.keys()):
    output.extend(reversed(diag[key]))
  return output


def test():
  assert findDiagonalOrder([[1, 2, 3], [4, 5, 6], [7, 8, 9]]) == [1, 4, 2, 7, 5, 3, 8, 6, 9]

test()
