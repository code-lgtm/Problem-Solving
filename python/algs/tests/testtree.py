import unittest
from ds.tree import BST

class TestBST(unittest.TestCase):
    def test_bst(self):
        bst = BST()
        bst.insert(5, 6)
        bst.insert(3, 7)
        bst.insert(2, 8)
        bst.insert(4, 9)
        bst.insert(8, 10)
        bst.insert(6, 11)
        bst.insert(9, 12)

        self.assertTrue(bst.get(6) == 11)
        self.assertTrue(bst.get(15) == None)
        self.assertTrue(bst.height() == 3)
