class Edge:
    def __init__(self, v, w, weight):
        self._v = v
        self._w = w
        self._weight = weight

    def either(self):
        return self._v

    def other(self, v):
        if v == self._v:
            return self._w
        return self._v
     
    def weight(self):
        return self._weight

    def __cmp__(self, other):
        if self._weight < other._weight:
            return -1
        elif self._weight > other._weight:
            return 1
        else:
            return 0

    def __str__(self):
        return str(self._v) + " -> " + str(self._w) + " : " + str(self._weight)
