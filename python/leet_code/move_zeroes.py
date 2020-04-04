def moveZeroes(nums):
  i, j = 0, 0
  n = len(nums)
  while j < n:
    while j < n and not nums[j]: j += 1
    if j >= n: break
    nums[i] = nums[j]
    i += 1
    j += 1
  
  while i < n:
    nums[i] = 0
    i += 1
  return nums


print(moveZeroes([0,1,0,3,12]))
  
