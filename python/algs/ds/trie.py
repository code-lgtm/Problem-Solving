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
