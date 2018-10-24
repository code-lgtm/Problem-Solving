"""
ID: kumar.g1
LANG: PYTHON2
TASK: combo
"""

fin = open ('combo.in', 'r')
fout = open ('combo.out', 'w')

N = int(fin.readline())
john_combo = map(int, fin.readline().rstrip("\n").split(" "))
master_combo = map(int, fin.readline().rstrip("\n").split(" "))

# Generate all possible values for each dial
tolerance_john = [list({(x+i)%N if (x+i)%N else N for i in range(-2, 3)})  for x in john_combo]
tolerance_master = [list({(x+i)%N if (x+i)%N else N for i in range(-2, 3)})  for x in master_combo]

# Identify Overlaps for each dial. Total overlap would be a product of each dial overlaps
overlap = [sum([1 for i in range(len((tolerance_john[0]))) for j in range(len((tolerance_john[0]))) if tolerance_john[x][i] == tolerance_master[x][j]]) for x in range(3)]
possible_combinations_john = len(tolerance_john[0]) * len(tolerance_john[1]) * len(tolerance_john[2])
possible_combinations_master = len(tolerance_master[0]) * len(tolerance_master[1]) * len(tolerance_master[2])
result = reduce((lambda x, y: x*y), overlap)

fout.write(str(possible_combinations_john+possible_combinations_master-result) + "\n")
fout.close()
