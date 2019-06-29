class Edge:
    def __init__(self, v, w, e):
        self.v = v
        self.w = w
        self.e = e

    def either(self):
        return self.v

    def other(self, v):
        if self.v == v:
            return self.w
        return self.v

    def weight(self):
        return self.e
