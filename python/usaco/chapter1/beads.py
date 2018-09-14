"""
ID: kumar.g1
LANG: PYTHON2
TASK: beads 
"""

fin = open ('beads.in', 'r')
fout = open ('beads.out', 'w')

N = int(fin.readline())
input_str = fin.readline().rstrip("\n")

def consecutive_beads(s, i, isleft):
    counter = 0
    index = i
    c = 'w'
    while counter < len(s):
        # First iteration
        if not counter:
            c = s[index]
        # Store current color in c
        elif c == 'w':
            c = s[index]
        # Count if current color is white
        elif s[index] == 'w':
            pass
        # Bresf if prev color does not match current color
        elif c != s[index]:
            break
        counter += 1
        index += -1 if isleft else 1
        if isleft and index < 0:
            index = len(s)-1
        if not isleft and index >= len(s):
            index = 0
    return counter

def max_beads(s):
    mbeads = 0
    for i in range(len(s)):
        left = consecutive_beads(s, i, True)
        right = consecutive_beads(s, (i+1)%len(s), False)

        if left+right > len(s):
            return len(s)
 
        if (left+right) > mbeads:
            mbeads = left+right
    return mbeads

fout.write(str(max_beads(input_str)) + "\n")
fout.close()
