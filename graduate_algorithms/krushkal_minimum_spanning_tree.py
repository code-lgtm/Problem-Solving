from graphs.edge import Edge
from graphs.edge_weighted_graph import EdgeWeightedGraph
from data_structures.weighted_quick_union import WeightedQuickUnion

if __name__ == "__main__":
    g = EdgeWeightedGraph(8)

    g.add_edge(Edge(0, 7, 0.16))
    g.add_edge(Edge(2, 3, 0.17))
    g.add_edge(Edge(1, 7, 0.19))
    g.add_edge(Edge(0, 2, 0.26))
    g.add_edge(Edge(5, 7, 0.28))
    g.add_edge(Edge(1, 3, 0.29))
    g.add_edge(Edge(1, 5, 0.32))
    g.add_edge(Edge(2, 7, 0.34))
    g.add_edge(Edge(4, 5, 0.35))
    g.add_edge(Edge(1, 2, 0.36))
    g.add_edge(Edge(4, 7, 0.37))
    g.add_edge(Edge(0, 4, 0.38))
    g.add_edge(Edge(6, 2, 0.40))
    g.add_edge(Edge(3, 6, 0.52))
    g.add_edge(Edge(6, 0, 0.58))
    g.add_edge(Edge(6, 4, 0.93))
    
    edges = sorted(g.edges(), key = lambda e : e.weight())
    wqu =  WeightedQuickUnion(g.V())

    mst = []
    weight = 0.0
    
    for e in edges:
        v = e.either()
        w = e.other(v)
        
        if not wqu.connected(v, w):
            wqu.union(v, w)
            mst.append(e)
            weight += e.weight()
    
    for e in mst:
        v = e.either()
        w = e.other(v)
        wt = e.weight()

        print(str(v) + "--->" + str(w) + ":" + str(wt))

    print('Total Weight : {0}'.format(weight))

