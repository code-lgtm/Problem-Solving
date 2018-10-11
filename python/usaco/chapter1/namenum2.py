import itertools

"""
ID: kumar.g1
LANG: PYTHON2
TASK: namenum
"""

fin_dict = open('dict.txt', 'r')
fin = open ('namenum.in', 'r')
fout = open ('namenum.out', 'w')

name_dict = []

for line in fin_dict:
    name_dict.append(line.rstrip("\n"))

brand = list(fin.readline().rstrip("\n"))
keymap = {
    'A': '2', 'B': '2', 'C': '2',
    'D': '3', 'E': '3', 'F': '3',
    'G': '4', 'H': '4', 'I': '4',
    'J': '5', 'K': '5', 'L': '5',
    'M': '6', 'N': '6', 'O': '6',
    'P': '7', 'R': '7', 'S': '7',
    'T': '8', 'U': '8', 'V': '8',
    'W': '9', 'X': '9', 'Y': '9',
}

l = []

for name in name_dict:
    if ''.join([keymap[c] for c in list(name) if c in keymap]) == ''.join(brand):
        l.append(name)

if len(l):
    for name in l:
        fout.write(name + "\n")
else:
    fout.write("NONE" + "\n")

fout.close()
