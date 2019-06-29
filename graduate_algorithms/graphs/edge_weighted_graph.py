from .edge import Edge

class EdgeWeightedGraph:
    def __init__(self, v):
        self.adj = [[] for _ in range(v)]
        self.e = 0
        self.v = v

    def V(self):
        return self.v

    def E(self):
        return self.e

    def add_edge(self, edge):
        v = edge.either()
        w = edge.other(v)
        self.e += 1
        self.adj[v].append(edge)
        self.adj[w].append(edge)

    def edges(self):
        el = []
        for i in range(self.v):
            for e in self.adj[i]:
                j = e.other(i)
                if j > i:
                    el.append(e)
        return el 

