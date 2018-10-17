"""
ID: kumar.g1
LANG: PYTHON2
TASK: barn1
"""

import heapq

fin = open ('barn1.in', 'r')
fout = open ('barn1.out', 'w')

M, S, C = map(int, fin.readline().rstrip("\n").split(" "))
occupied = []

for i in range(C):
    occupied.append(int(fin.readline().rstrip("\n")))

def min_stalls(m, s, c):
    # No empty covered stall if number of stalls are less than equal to
    # boards available
    if len(c) <= m:
        return len(c)

    c = sorted(c)
    nstalls = 1
    gaps = []
    last = c[0]
    boards = 1
    for i in range(1, len(c)):
        # Cover consecutive covered stalls with single board
        if c[i]-last == 1:
            last = c[i]
            nstalls += 1
            continue
        # Do not create any gaps if there are boards available
        if boards < M:
            heapq.heappush(gaps, c[i]-last-1)
            boards += 1
            nstalls += 1
        else:
            # Introduce smallest gap in solution if a gap has to be introduced
            if len(gaps) > 0 and c[i]-last-1 >= gaps[0]:
                nstalls += heapq.heappushpop(gaps, c[i]-last-1) + 1
            else:
                nstalls += c[i]-last
        last = c[i]
    return nstalls 

fout.write(str(min_stalls(M, S, occupied)) + "\n")
fout.close()
