class EdgeWeightedGraph:
    def __init__(self, v):
        self._v = v
        self._adj = [[] for _ in range(v)]
        self._e = 0
 
    def add_edge(self, e):
        v = e.either()
        w = e.other(v)
        
        self._adj[v].append(e)
        self._adj[w].append(e)
        self._e += 1

    def adj(self, v):
        return self._adj[v]

    def num_vertices(self):
        return self._v

    def num_edges(self):
       return self._e

    def edges(self):
        return [e for v in range(self._v) for e in self.adj(v)]
