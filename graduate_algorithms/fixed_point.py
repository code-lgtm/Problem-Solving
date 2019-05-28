def fixed_point(A, left, right):
  if left > right:
    return False

  mid = (left+right)/2

  if mid == A[mid]:
    return True
  elif A[mid] > mid:
    return fixed_point(A, left, mid-1)
  else:
    return fixed_point(A, mid+1, right)

A = [-5, -4, -3, 3, 8, 12, 15, 18, 19, 56, 67, 89, 91, 101, 121, 155, 177, 201, 213]
A = [1, 2, 3, 4, 8, 12, 15, 18, 19, 56, 67, 89, 91, 101, 121, 155, 177, 201, 213]

print fixed_point(A, 0, len(A)-1)
