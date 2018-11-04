"""
ID: kumar.g1
LANG: PYTHON2
TASK: ariprog
"""

from operator import itemgetter
import time

fin = open("ariprog.in", "r")
fout = open("ariprog.out", "w")

# MAX_S = 2*250*250+1

n = int(fin.readline())
m = int(fin.readline())

def ari_prog(N, M):
    squares = [i*i for i in range(M+1)]
    S = [0] * (2*M*M+1)
    bisquares = []

    for i in range(len(squares)):
        for j in range(i, len(squares)):
            bisquares.append(squares[i]+squares[j])
            S[squares[i]+squares[j]] = 1

    bisquares = sorted(list(set(bisquares)))

    output = []
    max_index  = 2 * squares[-1]
    # t0 = time.clock()

    for x in xrange(len(bisquares)):
        a = bisquares[x]
        for y in xrange(x+1, len(bisquares)):
            b = bisquares[y]
            found = True
            # Break early if last index is going out of bounds
            if (N-1)*b-(N-2)*a > max_index:
                break
            for i in range(N-1, 1, -1):
                # Doing a reverse check gives better performance
                if not S[i*b - (i-1)*a]:
                    found = False
                    break
            if found:
                output.append((a, b-a)) 

    # t1 = time.clock()
    # print t1-t0
    # print len(bisquares) * len(bisquares)/(2.2*(10**9))
    return output

output = ari_prog(n,m)

if not len(output):
    fout.write('NONE\n')
else:
    output = sorted(output, key=itemgetter(1, 0))
    for a, d in output:
        fout.write(str(a) + " " + str(d) + "\n")

fout.close() 
