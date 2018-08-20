# https://www.interviewbit.com/problems/maximum-absolute-difference/

def maxArr(A):
    len_a = len(A)
    arr1 = [0] * len_a
    arr2 = [0] * len_a
    min_1, min_2 = float("inf"), float("inf")
    max_1, max_2 = float("-inf"), float("-inf")
    
    for i in range(len_a):
        num1 = A[i] - i
        num2 = A[i] + i

        if num1 > max_1:
            max_1 = num1
        if num1 < min_1:
            min_1 = num1
    
        if num2 > max_2:
            max_2 = num2
        if num2 < min_2:
            min_2 = num2

    return max(abs(max_1 - min_1), abs(max_2 - min_2))

def test():
    assert maxArr([1, 3, -1]) == 5

test()


