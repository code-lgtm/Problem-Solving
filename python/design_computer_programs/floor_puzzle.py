import itertools

def floor_puzzle():
  floors = {"Hopper":-1, "Kay":-1, "Perlis":-1, "Ritchie":-1, "Liskov":-1}
  n = len(floors)
  li = [i for i in range(n)]
  for i in li: # Hopper
    if not i: # Does not live on top floor
      continue
    lj = li.copy()
    lj.remove(i)
    for j in lj: # Kay
      if j == n-1: # Does not live on bottom floor
        continue
      lk = lj.copy()
      lk.remove(j)
      for k in lk: # Liskov
        if k == 0 or k == n-1 or k==j-1 or k==j+1:
          continue
        ll = lk.copy()
        ll.remove(k)
        for l in  ll: # Perlis
          if l > j:
            continue
          lm = ll.copy()
          lm.remove(l)
          for m in lm: # Ritchie
            if m==k+1 or m==k-1:
              continue
            floors["Hopper"] = i
            floors["Kay"] = j
            floors["Liskov"] = k
            floors["Perlis"] = l
            floors["Ritchie"] = m
            return floors
  return None
           
def next_setting(iterable):
  for l in itertools.permutations(iterable):
    yield(l)
 
def floor_puzzle2():
  floors = {"Hopper":-1, "Kay":-1, "Perlis":-1, "Ritchie":-1, "Liskov":-1}
  for l in next_setting(floors):
    for person in l:
      floors[person] = l.index(person)
    if floors["Hopper"] == 0:
      continue
    if floors["Kay"] == len(floors)-1:
      continue
    if floors["Liskov"] == 0 or floors["Liskov"] == len(floors)-1:
      continue
    if floors["Liskov"] == floors["Kay"]-1 or floors["Liskov"] == floors["Kay"]+1:
      continue
    if floors["Perlis"] > floors["Kay"]:
      continue
    if floors["Ritchie"] == floors["Liskov"]-1 or floors["Ritchie"] == floors["Liskov"]+1:
      continue
    return l
  return None

print(floor_puzzle2())    
