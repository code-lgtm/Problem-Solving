import math
from collections import deque

def isprime(x):
    if x == 0 or x == 1:
        return False
    if x == 2:
        return True

    if not x%2:
        return False

    for i in range(3, int(math.floor(math.sqrt(x)))+1, 2):
         if not x%i:
             return False
    return True

def getfactors(n, m, level, queue, mp):
    for i in range(2, int(math.floor(math.sqrt(n)))+1):
        if not n%i:
            if n+i<=m and not mp[n+i]: 
                queue.append((n+i, level))
                mp[n+i] = True
            if n+n/i<=m and not mp[n+n/i]: 
                queue.append((n+n/i, level))
                mp[n+n/i] = True

def minOperations(n, m, mp):
    queue = deque()
    getfactors(n, m, 1, queue, mp)
   
    while len(queue):
        x = queue.popleft()
        if x[0] == m:
            return x[1]
        elif x[0] < m:
            getfactors(x[0], m, x[1]+1, queue, mp)
    return -1

def countOperations(n, m):
   if m == n:
       return 0

   if isprime(n) or isprime(m):
       return -1

   if m < n:
       return -1

   mp = [False] * (m+1)

   return minOperations(n, m, mp)
    


if __name__ == "__main__":
    assert countOperations(4, 24) == 5 
    assert countOperations(4, 576) == 14
    assert countOperations(8748, 83462) == 10 
    assert countOperations(235, 98234) == 21 
    assert countOperations(82736, 82736) == 0 
    assert countOperations(4, 99991) == -1 
