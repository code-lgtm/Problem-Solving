class WeightedQuickUnion:
    def __init__(self, n):
        self.size = [1 for _ in range(n)]
        self.parent = [i for i in range(n)]
        self.count = n

    def find(self, p):
        while p != self.parent[p]:
            p = self.parent[p]
        return p

    def connected(self, p, q):
        root_p = self.find(p)
        root_q = self.find(q)

        return root_p == root_q

    def union(self, p, q):
        root_p = self.find(p)
        root_q = self.find(q)
    
        if self.size[root_p] < self.size[root_q]:
            self.parent[root_p] = root_q
            self.size[root_q] += self.size[root_p]
        else:
            self.parent[root_q] = root_p
            self.size[root_p] += self.size[root_q]

        self.count -= 1


if __name__ == "__main__":
    wqu = WeightedQuickUnion(10)
    wqu.union(4, 3)
    wqu.union(4, 9)
    wqu.union(3, 8)

    wqu.union(6, 5)
    wqu.union(0, 5)

    wqu.union(1, 2)
    wqu.union(2, 7)


    assert(not wqu.connected(6, 7))
    assert(wqu.connected(1, 7))
    assert(not wqu.connected(9, 7))
    assert(wqu.connected(9, 8))
    assert(wqu.connected(6, 0))
    assert(not wqu.connected(6, 8))

