import unittest
from dp.optimal_bst import minimum_cost

class TestOptimalBST(unittest.TestCase):
    def test_bst(self):
        self.assertTrue(minimum_cost([14], [6]) == 6)
        self.assertTrue(minimum_cost([10, 12, 16, 21], [4, 2, 6, 3]) == 26)
        self.assertTrue(minimum_cost([10, 12, 17], [1, 3, 1]) == 7)
