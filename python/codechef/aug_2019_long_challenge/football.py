T = int(input())

for _ in range(T):
    N = int(input())
    A = list(map(int, input().split()))
    B = list(map(int, input().split()))
    m = 0
    for i in range(N):
        r  = A[i]*20 - B[i]*10
        if r > m:
            m  = r
    print(m)
