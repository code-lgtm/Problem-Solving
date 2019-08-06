T = int(input())

for _ in range(T):
    s = input()
    n_1 = 0
    for c in s:
        if c == '1':
            n_1 += 1
    if n_1%2:
        print('WIN')
    else:
        print('LOSE')
