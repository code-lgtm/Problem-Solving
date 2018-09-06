import unittest
from ds.quickunionuf import QuickUnionUF

class TestQuickUnionUF(unittest.TestCase):
    def test_quickunion_uf(self):
        qu = QuickUnionUF(10)

        qu.union(4, 3) 
        qu.union(8, 3) 
        qu.union(6, 5) 
        qu.union(4, 9) 
        qu.union(2, 1) 
        qu.union(5, 0) 
        qu.union(7, 2) 
        qu.union(6, 1)
        
        self.assertFalse(qu.connected(4, 2))
        self.assertTrue(qu.connected(4, 8))
 

