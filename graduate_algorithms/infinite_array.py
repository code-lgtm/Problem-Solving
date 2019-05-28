def bin_search(A, x, left, right):
  if left > right:
    return False

  mid = (left+right)/2
  if x == A[mid]:
    return True
  elif x < A[mid]:
    return bin_search(A, x, left, mid-1)
  else:
    return bin_search(A, x, mid+1, right)


def find(A, x):
  i = 1
  while A[i-1] != float("inf"):
    i = i<<1

  i = i>>1
  return bin_search(A, x, 0, i-1)

A = [1, 2, 2, 5, 6, 7, 7, 8, float("inf"), float("inf"), float("inf"), float("inf"), float("inf"), float("inf"), float("inf"), float("inf")]

print find(A, 7)
