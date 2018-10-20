import unittest
from dp.optimal_bst import minimum_cost, minimum_cost_tree

class TestOptimalBST(unittest.TestCase):
    def test_bst(self):
        self.assertTrue(minimum_cost([14], [6]) == 6)
        self.assertTrue(minimum_cost([10, 12, 16, 21], [4, 2, 6, 3]) == 26)
        self.assertTrue(minimum_cost([10, 12, 17], [1, 3, 1]) == 7)
        self.assertTrue(minimum_cost_tree([10, 12, 17], [1, 3, 1]) == [12, 10, 17])
        self.assertTrue(minimum_cost_tree([10, 12, 16, 21], [4, 2, 6, 3]) == [16, 10, 12, 21])
        
