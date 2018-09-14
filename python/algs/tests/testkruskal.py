import unittest
from ds.edgeweightedgraph import EdgeWeightedGraph
from ds.edge import Edge
from greedy.mstkruskal import MSTKruskal

class TestKruskal(unittest.TestCase):
    def testkruskal(self):
        g = EdgeWeightedGraph(8)

        g.add_edge(Edge(4, 5, 0.35))
        g.add_edge(Edge(4, 7, 0.37))
        g.add_edge(Edge(5, 7, 0.28))
        g.add_edge(Edge(0, 7, 0.16))
        g.add_edge(Edge(1, 5, 0.32))
        g.add_edge(Edge(0, 4, 0.38))
        g.add_edge(Edge(2, 3, 0.17))
        g.add_edge(Edge(1, 7, 0.19))
        g.add_edge(Edge(0, 2, 0.26))
        g.add_edge(Edge(1, 2, 0.36))
        g.add_edge(Edge(1, 3, 0.29))
        g.add_edge(Edge(2, 7, 0.34))
        g.add_edge(Edge(6, 2, 0.40))
        g.add_edge(Edge(3, 6, 0.52))
        g.add_edge(Edge(6, 0, 0.58))
        g.add_edge(Edge(6, 4, 0.93))

        self.assertTrue(g.num_vertices() == 8)
        self.assertTrue(g.num_edges() == 16)

        mst = MSTKruskal(g)
        self.assertTrue(mst.weight(), 1.81)
