T = int(input())

for _ in range(T):
    N = int(input())
    C = list(map(int, input().split()))
    H = list(map(int, input().split()))
    l = [0] * (N+1)
    for i in range(N):
        j = i-C[i]
        k = i+C[i]+1
        if j < 0:
            j = 0
        if k > N:
            k = N
        l[j] += 1
        l[k] -=1

    l.pop()
    for i in range(1, N):
        l[i] += l[i-1]

    H.sort()
    l.sort()
    if H==l:
        print("YES")
    else:
        print("NO")
