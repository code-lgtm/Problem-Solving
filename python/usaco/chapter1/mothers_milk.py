"""
ID: kumar.g1
LANG: PYTHON2
TASK: milk3 
"""

fin = open ('milk3.in', 'r')
fout = open ('milk3.out', 'w')

A, B, C = map(int, fin.readline().rstrip("\n").split(" "))

def states(state, capacity, h):
    for i in range(3):
        if not state[i]:
            continue
        i1 = (i+1) % 3
        i2 = (i+2) % 3
        rem1 =  capacity[i1] - state[i1]
        rem2 =  capacity[i2] - state[i2]

        for index, rem in zip((i1, i2), (rem1, rem2)):
            lstate = list(state)
            if state[i] <= rem:
                lstate[i] = 0
                lstate[index] += state[i]
            else:
                lstate[index] = capacity[index]
                lstate[i] -= rem
            if lstate not in h:
                yield tuple(lstate)


output = []
h = []

def milk3(state, capacity):
    if state in h:
        return

    h.append(state)

    for next_state in states(state, capacity, h):
        if not next_state[0] and next_state[2] not in output:
            output.append(next_state[2])
        milk3(next_state, capacity)

output.append(C)
milk3((0, 0, C), (A, B, C))

output = sorted(output)
fout.write(str(output[0]))
for i in range(1, len(output)):
    fout.write(" "+ str(output[i]))
fout.write("\n")

fout.close()
fin.close()
