import collections

def icecreamParlor(m, arr):
    x = collections.defaultdict(int)
    for i in range(len(arr)):
        diff = m - arr[i]
        if diff <= 0:
            continue
        elif arr[i] not in x:
            x[diff] = i
        else:
            return [x[arr[i]]+1, i+1]
    return None        

def test():
    assert icecreamParlor(4, [1, 4, 5, 3, 2]) == [1, 4]
    assert icecreamParlor(4, [2, 2, 4, 3]) == [1, 2]

test()
    
