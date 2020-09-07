T = int(input())

for _ in range(T):
  N = int(input())
  matrix = []
  for _ in range(N):
    matrix.append(list(map(int, input().split())))
  
  i, j = 0, 0
  if matrix[i][j+1] == 2: j += 1
  else: i += 1
  ops = 0 
  
  for k in range(2, N):
    if not i: # We are currently at row zero
      if matrix[i][j+1] == k+1: j += 1
      else: # Next number is at column
        i = j+1
        j = 0
        ops += 1
    else: # We are currently at column zero
      if matrix[i+1][j] == k+1: i += 1
      else:
        j = i+1
        i = 0
        ops += 1
  if i: ops += 1 # One last transpose needed to sort row major
  print(ops)
