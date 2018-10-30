def combinations(iterable, r):
    # combinations('ABCD', 2) --> AB AC AD BC BD CD
    # combinations(range(4), 3) --> 012 013 023 123
    pool = tuple(iterable)
    n = len(pool)
    if r > n:
        return
    indices = range(r)
    yield tuple(pool[i] for i in indices)
    while True:
        for i in reversed(range(r)):
            # indices[i] has reached at end of iterable?
            # Ensure each indice cannot reach past its maximum allowed index
            if indices[i] != i + n - r:
                # No
                break
        else:
            return
        # Adjust indices by 1
        indices[i] += 1
        for j in range(i+1, r):
            indices[j] = indices[j-1] + 1
        yield tuple(pool[i] for i in indices)

for i in combinations('ABCD', 3):
    print i
