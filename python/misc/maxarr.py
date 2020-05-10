# https://www.interviewbit.com/problems/maximum-absolute-difference/


def maxArr(A):
    max_abs_diff = float("-inf")
    for i in range(len(A)-1):
        for j in range(i+1, len(A)):
           max_abs_diff = max(max_abs_diff , abs(A[j] - A[i]) + j - i)
    return max_abs_diff

def test():
    assert maxArr([1, 3, -1]) == 5

test()
