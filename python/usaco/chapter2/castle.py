"""
ID: kumar.g1
LANG: PYTHON2
TASK: castle
"""

class Node:
    def __init__(self, mask):
        self.north = not ((mask>>1)&1)
        self.south = not ((mask>>3)&1)
        self.east = not ((mask>>2)&1)
        self.west = not (mask&1)

fin = open ('castle.in', 'r')
fout = open ('castle.out', 'w')

M, N  = map(int, fin.readline().rstrip("\n").split(" "))

A = []

for i in range(N):
    A.append([])
    l = map(int, fin.readline().rstrip("\n").split(" "))
    for j in range(M):
        A[i].append(Node(l[j]))

visited = []
for i in range(N):
    visited.append([False] * M)

cc = []
counter = 0
cc_details = []

def dfs(i, j, c):
    if visited[i][j]:
        return 0

    visited[i][j] = True
    A[i][j].component = c
    if i > cc_details[c][0]:
        cc_details[c][0] = i
    if j < cc_details[c][1]:
        cc_details[c][1] = j

    x = 1
    if A[i][j].north:
        if i-1 >= 0:
            x += dfs(i-1, j, c)

    if A[i][j].south:
        if i+1 < N:
            x += dfs(i+1, j, c)

    if A[i][j].west:
        if j >= 0:
            x += dfs(i, j-1, c)

    if A[i][j].east:
        if j+1 < M:
            x += dfs(i, j+1, c)
    return x

for i in range(N):
    for j in range(M):
        if not visited[i][j]:
            cc_details.append([i, j])
            cc_size = dfs(i, j, counter)
            cc.append(cc_size)
            counter += 1

merge_details = (max(cc), 0, 0, 0, 0, '')

for j in range(M):
    for i in range(N-1, -1, -1):
        if not A[i][j].north and i-1>=0:
            component1 = A[i][j].component 
            component2 = A[i-1][j].component 
            if component1 != component2:
                new_size = cc[A[i][j].component] + cc[A[i-1][j].component]
                if new_size > merge_details[0]:
                    merge_details = (new_size, component1, component2, i, j, 'N')

        if not A[i][j].east and j+1<M:
            component1 = A[i][j].component 
            component2 = A[i][j+1].component 
            if  component1 != component2:
                new_size = cc[component1] + cc[component2]
                if new_size > merge_details[0]:
                    merge_details = (new_size, component1, component2, i, j, 'E')


fout.write(str(len(cc)) + "\n")
fout.write(str(max(cc)) + "\n")
fout.write(str(merge_details[0]) + "\n")
fout.write(str(merge_details[3]+1) + " ")
fout.write(str(merge_details[4]+1) + " ")
fout.write(merge_details[5] + "\n")

fin.close()
fout.close()
