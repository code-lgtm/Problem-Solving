
import unittest
from ds.trie import Trie

class TestTrie(unittest.TestCase):
    def testinsertion(self):
        trie = Trie()
        trie.put("GREG", True)

        self.assertTrue(trie.get("GREG"))
        self.assertIsNone(trie.get("GREM"))   
