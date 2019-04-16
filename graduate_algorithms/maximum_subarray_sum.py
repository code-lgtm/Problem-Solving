def maxSubarray(arr):
    arr_len = len(arr)
    L = [0 for _ in range(arr_len+1)]
    for i in range(1, arr_len+1):
        L[i] = arr[i-1]+L[i-1] if L[i-1] > 0 else arr[i-1]
    max_subarray = max(L)
    if max_subarray <= 0:
        max_subarray = max(arr)
    
    L = [0 for _ in range(arr_len+1)]
    for i in range(1, arr_len+1):
        if arr[i-1] > 0:
            L[i] = L[i-1] + arr[i-1]
        else:
            L[i] = L[i-1]
    max_subseq = max(L)
    if max_subseq <= 0:
        max_subseq = max(arr)
    return (max_subarray, max_subseq)

assert maxSubarray([2, -1, 2, 3, 4, -5]) == (10, 11)
