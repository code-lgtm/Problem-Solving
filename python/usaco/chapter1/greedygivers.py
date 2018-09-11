"""
ID: kumar.g1
LANG: PYTHON2
TASK: gift1
"""

fin = open ('gift1.in', 'r')
fout = open ('gift1prog.out', 'w')

eap  = int(fin.readline())
names = [fin.readline().rstrip('\n') for _ in range(np)]
accounts = {name:0 for name in names}

for i in range(np):
    name = fin.readline().rstrip('\n')
    x, y = map(int, fin.readline().split())
    friends = []

    if y:
        accounts[name] += (-x + (x%y))
    else:
        accounts[name] += x

    for _ in range(y):
        friend = fin.readline().rstrip('\n')
        accounts[friend] += x/y

for i in range(len(names)):
    fout.write(names[i] + " " + str(accounts[names[i]]) + "\n")

fout.close()
