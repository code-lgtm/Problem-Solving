import itertools

"""
ID: kumar.g1
LANG: PYTHON2
TASK: namenum
"""


# Slow Solution using Trie

class Node:
    def __init__(self):
        self.value = None
        self.links = [None for _ in range(256)]

class Trie:
    def __init__(self):
        self._root = Node()

    def get(self, key):
        x =  self.getval(self._root, key, 0)
        if x:
            return x.value
        else:
            return None

    def getval(self, x, key, d):
        if not x:
            return None
        if d == len(key):
            return x
        c = ord(key[d])
        return self.getval(x.links[c], key, d+1)

    def put(self, key, value):
        self._root = self.putval(self._root, key, value, 0)

    def putval(self, x, key, value, d):
        if not x:
            x = Node()
        if d == len(key):
            x.value = value
            return x
        c = ord(key[d])
        x.links[c] = self.putval(x.links[c], key, value, d+1)
        return x

fin_dict = open('dict.txt', 'r')
fin = open ('namenum.in', 'r')
fout = open ('namenum.out', 'w')

trie = Trie()

for line in fin_dict:
    trie.put(line.rstrip("\n"), True)

brand = list(fin.readline().rstrip("\n"))
keymap = {
    '2': ('A', 'B', 'C'), 
    '3': ('D', 'E', 'F'), 
    '4': ('G', 'H', 'I'), 
    '5': ('J', 'K', 'L'),
    '6': ('M', 'N', 'O'),
    '7': ('P', 'R', 'S'),
    '8': ('T', 'U', 'V'),
    '9': ('W', 'X', 'Y')
}

l = []
for tname in itertools.product(*[keymap[i] for i in brand]):
    name = ''.join(tname)
    if trie.get(name):
        l.append(name)

if len(l):
    for name in l:
        fout.write(name + "\n")
else:
    fout.write("NONE" + "\n")

fout.close()
