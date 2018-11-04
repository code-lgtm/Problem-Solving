import time

def timedcall(fn, *args):
    t0 = time.clock()
    result = fn(*args)
    t1 = time.clock()
    return t1-t0, result

def average(numbers):
    return sum(numbers)/float(len(numbers))
    
def timedcalls(n, fn, *args):
    if isinstance(n, int):
        times = [timedcall(fn, *args)[0] for _ in range(n)]
    else:
        times = []
        while sum(times) < n:
            times.append(timedcall(fn, *args)[0])
    return min(times), average(times), max(times)

def instrument_fn(fn, *args):
    c.starts, c.items = 0, 0
    result = fn(*args)
    print '%s got %s with %5d iters over %7d items' % (
        fn.__name__, result, c.starts, c.items)

def c(sequence):
    """Generate items in sequence; keeping counting as we go. c.starts
    is the numeber of sequences started; c.items is number of items
    generated."""
    c.starts += 1
    for item in sequence:
        c.items += 1
        yield item 
