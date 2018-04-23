# https://www.hackerrank.com/challenges/countingsort4/problem
import collections

def key_indexed_counting(input):
    nitems = len(input)
    aux = [None] * nitems
    count = [0] * 101

    for i in range(nitems/2):
        input[i][1] = '-'

    for i in range(nitems):
        count[input[i][0] + 1] += 1

    for i in range(1, len(count)):
        count[i] = count[i] + count[i-1]

    for i in range(nitems):
        aux[count[input[i][0]]] = input[i]
        count[input[i][0]] += 1

    return ' '.join([aux[i][1] for i in range(nitems)])

def test():
    assert key_indexed_counting([[0, 'a'], [1, 'b'], [0, 'c'], [1, 'd']]) == "- c - d" 
    assert key_indexed_counting([[0, 'ab'], [6, 'cd'], [0, 'ef'], [6, 'gh'], [4, 'ij'], [0, 'ab'], [6, 'cd'], [0, 'ef'], [6, 'gh'], [0, 'ij'], [4, 'that'], [3, 'be'], [0, 'to'], [1, 'be'], [5, 'question'], [1, 'or'], [2, 'not'], [4, 'is'], [2, 'to'], [4, 'the']]) == "- - - - - to be or not to be - that is the question - - - -"

test() 



