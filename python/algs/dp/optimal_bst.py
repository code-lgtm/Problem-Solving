'''
    Given frequencies for each key devise an algorithm to construct binary search tree
    which is optimal in terms of cost of lookup operations
'''

def minimum_cost_matrix(keys, frequencies):
    nkeys = len(keys)
    A = [[(float("inf"), 0) for _ in range(nkeys)] for __ in range(nkeys)]
    for i in range(nkeys):
        A[i][i] = (frequencies[i], i)    

    for s in range(1, nkeys):
        for i in range(nkeys):
            if i+s < nkeys:
                frequency_total = sum([frequencies[r] for r in range(i, i+s+1)])
                cost_r = []
                for r in range(i, i+s+1):
                    cleft = A[i][r-1][0] if r-1 >= 0 else 0
                    cright = A[r+1][i+s][0] if r+1 < nkeys else 0
                    cost_r.append((cleft + cright, r))
                min_cost_r = min(cost_r)
                A[i][i+s] = (frequency_total + min_cost_r[0], min_cost_r[1])
    return A

def minimum_cost(keys, frequencies):
    return minimum_cost_matrix(keys, frequencies)[0][len(keys)-1][0]

def minimum_cost_tree(keys, frequencies):
    A = minimum_cost_matrix(keys, frequencies)
    



