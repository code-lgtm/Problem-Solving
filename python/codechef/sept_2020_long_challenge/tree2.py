# https://www.codechef.com/SEPT20B/problems/TREE2

T = int(input())

for _ in range(T):
  x = input()
  l = list(map(int, input().split()))
  s = set(l)
  m = min(s)
  ops = len(s)
  if m: print(ops)
  else: print(ops-1)
