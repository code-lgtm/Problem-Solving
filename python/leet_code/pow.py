def myPow(x, y):
  l = [0] * 32
  if y < 0 : 
    x = 1/x
    y = -y

  def pow(x, y, i, l):
    n = 1 << i
    if n > y: return
    l[i] = l[i-1] * l[i-1]
    return pow(x, y, i+1, l)
  
  l[0] = x
  pow(x, y, 1, l)

  result = 1
  for i in range(32):
    j = 1 << i
    if j&y: result *= l[i]
  return result


print(myPow(2, 10))


