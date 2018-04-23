import collections

def instrument_fn(fn, *args):
    c.starts, c.items = 0, 0
    result = fn(*args)
    print '%s got %s with %5d iters over %7d items' % (fn.__name__, result, c.starts, c.items)

def c(sequence):
    c.starts += 1
    for item in sequence:
        c.items += 1
        yield item

def longest_word_subsequence_brute(S, D):
    D = sorted(D, reverse= True)
    for d in c(D):
        x = 0
        y = 0
        while x < len(S):
            if S[x] == d[y]:
                x += 1
                y += 1
                if y == len(d):
                    return d
            else:
                x += 1
    return None

def longest_word_subsequence_optimal(S, D):
    map_c = collections.defaultdict(list)

    for d in D:
        map_c[d[0]].append((d, 0))    

    found = []
    for ch in S:
        if map_c[ch]:
            change_list = [t for t in map_c[ch]]
            for item in change_list:
                if item[1] == len(item[0]) - 1:
                    found.append(item[0])
                else:
                    p = item[0][item[1]+1]
                    map_c[p].append((item[0], item[1]+1))
                map_c[ch].remove(item)    
    return found
         

def test():
    assert longest_word_subsequence_brute("abppplee" , ["able", "ale", "apple", "bale", "kangaroo"]) == "apple"
    assert longest_word_subsequence_brute("", ["hello"]) == None
    assert longest_word_subsequence_brute("abc", ["x", "xy"]) == None
    assert longest_word_subsequence_brute("ab", ["abb", "ab"]) == "ab"
    assert longest_word_subsequence_brute("ab", []) == None
    assert longest_word_subsequence_brute([], []) == None

    # from itertools import product
    # from string import ascii_lowercase
    # assert longest_word_subsequence_brute("aba", ["".join(x) for x in product(ascii_lowercase, 2)]) == "ab" 
    return "tests pass"

# print test()
# instrument_fn(longest_word_subsequence_brute, "abppplee" , ["able", "ale", "apple", "bale", "kangaroo"]) 

print longest_word_subsequence_optimal("abppplee" , ["aaaaaaa", "able", "ale", "apple", "bale", "kangaroo"]) 

import time

def timedcall(fn, *args):
    t0 = time.clock()
    result = fn(*args)
    t1 = time.clocl()
    return t1-t0, result

def timedcalls(n, fn, *args):
    if isinstance(n, int):
        times = [timedcall(fn, *args)[0] for _ in range(n)]
    else:
        times = []
        while sum(times) < n:
            times.append(timedcall(fn, *args)[0])
    return min(times), average(times), sum(times)



# Concept Inventory
# Representation
# Refine Ideas
# Simple Implementation
# Back Envelope
# Refine Code
