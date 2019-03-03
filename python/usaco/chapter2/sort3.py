"""
ID: kumar.g1
LANG: PYTHON2
TASK: sort3
"""

fin = open('sort3.in', 'r')
fout = open('sort3.out', 'w')

l = []
N = int(fin.readline().rstrip("\n"))

for _ in range(N):
  l.append(int(fin.readline().rstrip("\n")))

indexes = {}

def get_indexes(i):
  'Given a value returns what indexes value is present in the list'
  return tuple([index for index, val in enumerate(l) if i==val])

def get_valid_indices(i):
  'Returns valid indices for i in the sorted array'
  len_1 = len(indexes[1])

  if i == 1:
    return (0, len_1-1)
  elif i == 2:
    len_2 = len(indexes[2])
    return (len_1, len_1+len_2-1)
  else:
    len_2 = len(indexes[2])
    return (len_1+len_2, len(l)-1)

def is_at_right_place(i, j):
  'Check if j is a valid location for element i'
  valid_loc = get_valid_indices(i)
  return (j >= valid_loc[0] and j <= valid_loc[1])

for i in range(3):
  indexes[i+1] = get_indexes(i+1)

exch = 0
for i in range(1, 4):
  for j in get_indexes(i):
    if is_at_right_place(i, j): continue
    else:
      valid_loc = get_valid_indices(i)
      for k in range(valid_loc[0], valid_loc[1]+1):
        if is_at_right_place(l[k], j):
          exch += 1
          temp = l[j]
          l[j] = l[k]
          l[k] = temp
          break

for index, val in enumerate(l):
  if val == 1:
    if not is_at_right_place(val, index):
      exch += 2

fout.write(str(exch) + "\n")
fout.close()
fin.close()

def test():
    assert(get_indexes(1)  == (2, 8))
    assert(get_valid_indices(1) == (0, 1))
    assert(get_valid_indices(2) == (2, 4))
    assert(get_valid_indices(3) == (5, 8))
    assert(is_at_right_place(1, 2) == False)
    assert(is_at_right_place(1, 0) == True)
    assert(is_at_right_place(2, 4) == True)
    assert(is_at_right_place(2, 1) == False)
    assert(is_at_right_place(3, 8) == True)
