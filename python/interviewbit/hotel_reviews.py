"""
ID: kumar.g1
LANG: PYTHON2
"""

fin = open ('hotel_reviews.in', 'r')

S = set(fin.readline().rstrip("\n").split("_"))
N = int(fin.readline())
R = [fin.readline().rstrip("\n").split("_") for _ in range(N)]

class TrieNode:
    def __init__(self):
        self.val = 0
        self.links = [None] * 26

class Trie:
    def __init__(self):
        self.root = TrieNode()
    
    def put(self, s):
        self.puts(self.root, s, 0)
        
    def puts(self, x, s, d):
        if not x:
            x = TrieNode()
        
        if len(s) == d:
            x.val += 1
            return x
        
        c = ord(s[d]) - 97
        x.links[c] = self.puts(x.links[c], s, d+1)
        return x
        
    def get(self, s):
        return self.gets(self.root, s, 0)
        
    def gets(self, x, s, d):
        if not x:
            return None
        if len(s) == d:
            return x.val
            
        c = ord(s[d]) - 97
        return self.gets(x.links[c], s, d+1)

t = Trie()
for s in S:
    t.put(s)

occurrences = []
for index, l in enumerate(R):
    c = 0
    for s in l:
        if t.get(s):
            c += 1
    occurrences.append((index, c))

from operator import itemgetter
print sorted(occurrences, key = itemgetter(1), reverse=True)
