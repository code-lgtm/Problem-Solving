import time

def generate_list(file):
    l = []
    f = open(file, 'r')

    for line in f:
        val = int(line)
        l.append(bin(val if val>0 else val+(1<<32))[2:].zfill(32))

    f.close()
    return l

def lsd(file):
    input = generate_list(file)
    print 'Starting'
    t0 = time.clock()
    nitems = len(input)

    for j in xrange(31, 0, -1):
        aux = [None] * nitems
        count = [0] * 3
        for i in range(nitems):
            count[int(input[i][j]) + 1] += 1

        for i in range(1, len(count)):
            count[i] = count[i] + count[i-1]

        for i in range(nitems):
            aux[count[int(input[i][j])]] = input[i]
            count[int(input[i][j])] += 1

        input = aux

    t1 = time.clock()

    print t1 - t0 

    return input


def test():
    pass

lsd('million_random_integers.txt')



# Try URLify strong
# Type Ahead using Trie : https://www.hackerrank.com/challenges/ctci-contacts/problem
# Given a tree if it is binary search tree
# String compression : aa bbb cc aaa -> a2b3c2a2 -> O(n) Time Complexity -> O(1) Space -> Popular question
# Buy Cracking the Coding Interview
