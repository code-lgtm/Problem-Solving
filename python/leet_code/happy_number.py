def get_square_sum(x):
  s = 0
  while x > 0:
    s += pow(x%10, 2)
    x //= 10
  return s

def isHappy(n):
  l = []
  while True:
    if n==1: return True
    if n in l: return False
    l.append(n)
    n = get_square_sum(n)
  return False

print(isHappy(91))
print(isHappy(2))
