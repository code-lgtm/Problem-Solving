import unittest
from ds.edge import Edge

class TestEdge(unittest.TestCase):
    def testweight(self):
        e1 = Edge(3, 5, 4)
        e2 = Edge(6, 7, 5)

        self.assertEqual(e1.either(), 3)
        self.assertEqual(e1.other(3), 5)
        self.assertTrue(e1 < e2)
        
