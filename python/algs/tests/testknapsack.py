import unittest
from dp.knapsack import unboundedKnapsack

class TestKnapsack(unittest.TestCase):
    def test_knapsack(self):
        self.assertTrue(unboundedKnapsack(12, [1,6,9]) == 12)
        self.assertTrue(unboundedKnapsack(9, [3,4,4,4,8]) == 9)
