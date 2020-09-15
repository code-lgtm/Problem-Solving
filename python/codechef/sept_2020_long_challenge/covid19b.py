# https://www.codechef.com/SEPT20B/problems/COVID19B
# Solution Strategy : Time and Distance Matters 
# If an atlete gets infected at time t and x, they cannot further infect an athlete that they meet at an earlier distance or time
# That is the reason why it is important to maintain a map of (t, x) where t is the time where 2 or more athletes meet at distance x



from collections import defaultdict

T = int(input())

for _ in range(T):
  N = int(input())
  V = list(map(int, input().split()))

  min_infections = float("inf")
  max_infections = 1
  infections = defaultdict(list)

  for i in range(N-1):
    for j in range(i+1, N):
      if V[i] > V[j]:
        t = (j-i)*60/(V[i]-V[j]) # Multiplied by 60 to ensure integer tim
        x = i*60 + V[i] * t
        infections[(t, x)].append(i)
        infections[(t, x)].append(j)

  for i in range(N):
    infected = [False] * N
    infected[i] = True
    
    for key in sorted(infections.keys()):
      if any(map(lambda i : infected[i], infections[key])):
        for athlete in infections[key]:
          infected[athlete] = True
    total_infections = sum(infected)
    min_infections = min(min_infections, total_infections)
    max_infections = max(max_infections, total_infections)

  print(min_infections, max_infections)

