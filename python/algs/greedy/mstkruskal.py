from ds.edgeweightedgraph import EdgeWeightedGraph
from ds.minpq import MinPQ
from ds.quickunionuf import QuickUnionUF

class MSTKruskal:
    def __init__(self, g):
        self._edges = []
        self._weight = 0

        minpq = MinPQ()
        for edge in g.edges():
            minpq.insert(edge)
        
        uf = QuickUnionUF(g.num_vertices())
        while (len(self._edges) < g.num_vertices()-1) and not minpq.isempty():
            edge = minpq.del_min()
            v = edge.either()
            w = edge.other(v)

            if not uf.connected(v, w):
                self._edges.append(edge)
                self._weight += edge.weight()
                uf.union(v, w)

    def edges(self):
        return self._edges

    def weight(self):
        return self._weight
