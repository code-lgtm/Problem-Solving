"""
ID: kumar.g1
LANG: PYTHON2
TASK: skidesign
"""

MAX_DIFF = 17
fin = open ('skidesign.in', 'r')
fout = open ('skidesign.out', 'w')


N = int(fin.readline())
hill_elevation = sorted([int(fin.readline()) for _ in range(N)])

def minimum_cost(arr):
    cost = float('inf')
    for min_curr_height in range(0, 83):
        cost_curr_height = 0
        for elevation in arr:
            if elevation < min_curr_height:
                cost_curr_height += (min_curr_height-elevation)**2
            elif elevation > min_curr_height+17:
                cost_curr_height += (elevation-min_curr_height-17)**2
        cost = min(cost, cost_curr_height)
    return cost

fout.write(str(minimum_cost(hill_elevation)) + "\n")
fout.close()
