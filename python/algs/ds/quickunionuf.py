class QuickUnionUF:
    def __init__(self, n):
        self._id = [i for i in range(n)]
        self._size = [0 for _ in range(n)]

    def _root(self, i):
        while i != self._id[i]:
            self._id[i] = self._id[self._id[i]]
            i = self._id[i]
        return i
            
    def connected(self, p, q):
        return self._root(p) == self._root(q)

    def union(self,p ,q):
        rootp = self._root(p)
        rootq = self._root(q)

        if self._size[rootp] < self._size[rootq]:
            self._size[rootq] += self._size[rootp]
            self._id[rootp] = self._id[rootq]
        else:
            self._size[rootp] += self._size[rootq]
            self._id[rootq] = self._id[rootp]
