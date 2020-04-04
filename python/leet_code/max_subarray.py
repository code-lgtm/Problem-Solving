def maxSubArray2(nums, l, r):
  if l == r:
    return (nums[l], nums[l], nums[l], nums[l])

  mid = (l+r)//2
  lr = maxSubArray2(nums, l, mid)
  rr = maxSubArray2(nums, mid+1, r)
   
  max_left = max(lr[0], lr[3]+rr[0])
  max_right = max(rr[1], rr[3]+lr[1])
  total_sum = lr[3]+rr[3]
  max_sum = max(max_left, max_right, lr[2], rr[2], total_sum, lr[1]+rr[0])

  return (max_left, max_right, max_sum, total_sum)
   


def maxSubArray(nums):
  return maxSubArray2(nums, 0, len(nums)-1)[2]


def maxSubArray_easy(nums):
  lsum = nums[0]
  rsum = nums[0]
        
  for i in range(1, len(nums)):
    if rsum >= 0 and nums[i] >= 0: rsum += nums[i]                
    elif rsum >= 0 and nums[i] < 0:
      if rsum+nums[i] >= 0: rsum += nums[i]
      else: rsum = nums[i]
    else: rsum = nums[i]
    if rsum > lsum: lsum = rsum
  return lsum

print(maxSubArray([-2,1,-3,4,-1,2,1,-5,4]))
print(maxSubArray_easy([-2,1,-3,4,-1,2,1,-5,4]))
