class DirectedGraph:
    def __init__(self, v):
        self.v = v
        self.e = 0
        self.adj = [[] for _ in range(v)]

    def V(self):
        return self.v

    def E(self):
        return self.e

    def add_edge(self, v, w):
        self.adj[v].append(w)

    def reverse(self):
        g_r = DirectedGraph(self.v)
        for i in range(self.v):
            for j in self.adj[i]:
                g_r.add_edge(j, i)
        return g_r
