class Node:
    def __init__(self, key, value):
        self._left = None
        self._right = None
        self._key = key
        self._value = value

class BST:
    def __init__(self):
        self._root = None
        self._N = 0

    def insert(self, key, value):
        self._root = self.insert_node(self._root, key, value)

    def insert_node(self, x, key, value):
        if not x:
            return Node(key, value)

        if key < x._key:
            x._left = self.insert_node(x._left, key, value)
        elif key > x._key:
            x._right = self.insert_node(x._right, key, value)
	else:
            x.value = value

        return x

    def get(self, key):
        return self.getval(self._root, key)

    def getval(self, x, key):
        if not x:
            return None

        if key < x._key:
            return self.getval(x._left, key)
        elif key > x._key:
            return self.getval(x._right, key)
	else:
            return x._value

    def height(self):
        return self.height_tree(self._root)

    def height_tree(self, x):
        if not x:
            return 0

        return 1 + max(self.height_tree(x._left), self.height_tree(x._right))
        
