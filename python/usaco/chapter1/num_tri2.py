"""
ID: kumar.g1
LANG: PYTHON2
TASK: numtri 
"""

from collections import deque

fin = open ('numtri.in', 'r')
fout = open ('numtri.out', 'w')

R = int(fin.readline().rstrip("\n"))

tri_input = []
tri_output = []
for _ in range(R):
    row = map(int, fin.readline().rstrip("\n").split(" "))
    tri_input.append(row)
    tri_output.append([0 for _ in range(R)])

for i in range(R):
    tri_output[R-1][i] = tri_input[R-1][i]

for i in range(R-2, -1, -1):
    for j in range(len(tri_input[i])):
        tri_output[i][j] = tri_input[i][j] + max(tri_output[i+1][j], tri_output[i+1][j+1])

fout.write(str(tri_output[0][0]) + "\n")
fout.close()
fin.close()




