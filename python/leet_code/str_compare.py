import itertools

def backspaceCompare_ineff(S, T):
  x, y = '', ''

  i = 0
  for s in S:
    if s != '#': x += s
    elif len(x) > 0: x = x[:-1] 

  for s in T:
    if s != '#': y += s
    elif len(y) > 0: y = y[:-1] 

  return x == y

def backspaceCompare(S, T):
  def F(S):
    skip = 0
    for x in reversed(S):
      if x == '#':
        skip += 1
      elif skip:
        skip -= 1
      else:
        yield x
  
  return all(x == y for x, y in itertools.izip_longest(F(S), F(T)))

def test():
  assert backspaceCompare("ab#c", "ad#c")
  assert backspaceCompare("ab##", "c#d#")
  assert backspaceCompare("a##c", "#a#c")
  assert not backspaceCompare("a#c", "b")

test()
