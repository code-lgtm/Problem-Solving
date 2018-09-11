from ds.minpq import MinPQ
from ds.edgeweightedgraph import EdgeWeightedGraph

class MSTPrimLazy:
    def __init__(self, g):
        self._pq = MinPQ()
        self._edges = []
        self._weight = 0
        self._visited = [False for _ in range(g.num_vertices())]
        self._visit(g, 0)

        while not self._pq.isempty():
            e = self._pq.del_min()
            v = e.either()
            w = e.other(v)

            if (not self._visited[v]) or (not self._visited[w]):
                self._edges.append(e)
                self._weight += e.weight()

            if not self._visited[v]:
                self._visit(g, v)

            if not self._visited[w]:
                self._visit(g, w)

    def _visit(self, g, v):
        self._visited[v] = True
        for e in g.adj(v):
            w = e.other(v)
            if not self._visited[w]:
                self._pq.insert(e)

    def edges(self):
        return self._edges

    def weight(self):
        return self._weight
