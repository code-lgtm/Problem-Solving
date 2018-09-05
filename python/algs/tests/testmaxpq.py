import unittest
from ds import maxpq

class TestMaxPQ(unittest.TestCase):
    def test_pq(self):
        pq = maxpq.MaxPQ()
        pq.insert(5)
        pq.insert(4)
        pq.insert(6)

        self.assertTrue(pq.is_valid_heap())
        self.assertEqual([i for i in pq.elements()], [6, 5, 4])
        self.assertEqual(pq.del_max(), 6)
        self.assertEqual(pq.del_max(), 5)
        self.assertEqual(pq.del_max(), 4)
        with self.assertRaises(IndexError):
            pq.del_max()
        

if __name__ == "__main__":
    unittest.main()
