T = int(input())

for _ in range(T):
    N, K = map(int, input().split())
    q = N/K
    if q%K:
        print("YES")
    else:
        print("NO")
