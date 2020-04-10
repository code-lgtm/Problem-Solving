def char_dict(s):
  d = [0]*32
  for c in s:
    d[ord(c) - 97] += 1
  return d

def are_anagrams(s1, s2):
  if len(s1) != len(s2): return False
  return sorted(s1) == sorted(s2)


def groupAnagrams(strs):
  output = []
  for s in strs:
    index = -1
    for i, l in enumerate(output):
      if are_anagrams(l[0], s):
        index = i
        break
    if index >= 0:
      output[index].append(s)
    else:
      output.append([s])
  return output

def test():
  assert are_anagrams("mary", "yram")
  assert are_anagrams("albert", "abelrt")
  assert not are_anagrams("something", "anotherus")

print(groupAnagrams(["eat", "tea", "tan", "ate", "nat", "bat"]))
