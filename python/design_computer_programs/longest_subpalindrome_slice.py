def traverse(i, j, text):
  while i > 0 and j < len(text):
    if text[i-1] != text[j]:
      break
    i -= 1
    j += 1
  return (i, j)

def longest_subpalindrome_slice(text):
  text = text.lower()
  if text == '':
    return(0, 0)
  start = 0
  end = 1
  max_length = end-start
  for i in range(len(text)):
    a, b = traverse(i, i, text)
    if b-a > max_length:
      start, end, max_length = a, b, b-a
    a, b = traverse(i, i+1, text)
    if b-a > max_length:
      start, end, max_length = a, b, b-a
  return (start, end)

def test():
    L = longest_subpalindrome_slice
    assert L('racecar') == (0, 7)
    assert L('Racecar') == (0, 7)
    assert L('RacecarX') == (0, 7)
    assert L('Race carr') == (7, 9)
    assert L('') == (0, 0)
    assert L('something rac e car going') == (8,21)
    assert L('xxxxx') == (0, 5)
    assert L('Mad am I ma dam.') == (0, 15)
    return 'tests pass'
 
test()    
    
