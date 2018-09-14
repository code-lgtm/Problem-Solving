class MinPQ():
    def __init__(self):
        self._pq = [None] # store items
        self._n = 0 # Number of items in priority queue

    def insert(self, x):
        self._pq.append(x)
        self._n += 1
        self._swim(self._n)

    def del_min(self):
        if not self._n:
            raise IndexError('Heap is empty')
        self._pq[1], self._pq[self._n] = self._pq[self._n], self._pq[1]
        x = self._pq.pop()
        self._n -= 1
        self._sink(1)
        return x
        

    def min(self):
        return self._pq[1]

    def _swim(self, k):
        while k > 1 and self._pq[k/2] > self._pq[k]:
            self._pq[k/2], self._pq[k] = self._pq[k], self._pq[k/2]
            k = k/2

    def _sink(self, k):
        while 2*k <= self._n:
            j = 2*k
            if j < self._n and self._pq[j] > self._pq[j+1]:
                j += 1
            if self._pq[k] < self._pq[j]:
                break
            self._pq[k], self._pq[j] = self._pq[j], self._pq[k]
            k = j

    def elements(self):
        import copy
        c_pq = copy.deepcopy(self)

        while not c_pq.isempty():
            yield c_pq.del_min()
    
    def isempty(self):
        return self._n == 0

    def size(self):
        return self._n

    def is_valid_heap(self):
        return self._is_min_heap(1)
    
    def _is_min_heap(self, k):
        if k >= self._n:
            return True

        i = 2*k
        j = 2*k+1

        if i <= self._n and self._pq[k] > self._pq[i]:
            return False 

        if j <= self._n and self._pq[k] > self._pq[j]:
            return False 

        return self._is_min_heap(i) and self._is_min_heap(j)

    def __iter__(self):
        return self

    def next(self):
        if self._n == 0:
            raise StopIteration

        return self.del_min()
