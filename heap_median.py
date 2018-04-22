from __future__ import division
import heapq

def find_median(x):
    hmax, hmin = [], []
    max_heap_size, min_heap_size = 0, 0
    
    for i in x:
        if max_heap_size == min_heap_size:
            if min_heap_size > 0 and i > hmin[0]:
                heapq.heappush(hmax, -heapq.heapreplace(hmin, i))
            else:
                heapq.heappush(hmax, -i)
            max_heap_size += 1
        else:
            if i < -hmax[0]:
                heapq.heappush(hmin , -heapq.heapreplace(hmax, -i))
            else:
                heapq.heappush(hmin, i)
            min_heap_size += 1

        if (max_heap_size + min_heap_size) % 2:
            print -hmax[0] / 1
        else:
            print (hmin[0] - hmax[0]) / 2

find_median([12, 4, 5, 3, 8, 7])
