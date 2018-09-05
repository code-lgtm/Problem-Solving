import unittest
from ds import minpq

class TestMinPQ(unittest.TestCase):
    def test_pq(self):
        pq = minpq.MinPQ()
        pq.insert(5)
        pq.insert(4)
        pq.insert(6)

        self.assertTrue(pq.is_valid_heap())
        self.assertEqual([i for i in pq.elements()], [4, 5, 6])
        self.assertEqual(pq.del_min(), 4)
        self.assertEqual(pq.del_min(), 5)
        self.assertEqual(pq.del_min(), 6)
        with self.assertRaises(IndexError):
            pq.del_min()
        

if __name__ == "__main__":
    unittest.main()
