
"""
ID: kumar.g1
LANG: PYTHON2
TASK: milk
"""

fin = open ('milk.in', 'r')
fout = open ('milk.out', 'w')

N, M = map(int, fin.readline().rstrip("\n").split(" "))
farmers = []

for i in range(M):
    farmers.append(tuple(map(int, fin.readline().rstrip("\n").split(" "))))

farmers = sorted(farmers, key = lambda farmer: farmer[0])

rem = N
cost = 0
for farmer in farmers:
    if rem > farmer[1]:
        cost += farmer[0] * farmer[1]
        rem = rem - farmer[1]
    elif rem <= 0:
        break
    else:
        cost += farmer[0] * rem
        break

fout.write(str(cost) + "\n")
fout.close()
