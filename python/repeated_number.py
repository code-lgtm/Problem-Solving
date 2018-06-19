# https://www.interviewbit.com/problems/repeat-and-missing-number-array/

def repeatedNumber(A):
    n = len(A)
    nSum = n*(n+1)/2
    n2Sum = n*(n+1)*(2*n+1)/6
    aSum = sum(A)
    a2Sum = sum([A[i]*A[i] for i in range(n)])
    diff = nSum - aSum
    addition = (n2Sum - a2Sum) / diff
    x = (diff + addition) / 2
    y = (addition - diff) / 2
    
    return [y, x]

def test():
    assert repeatedNumber([3, 1, 2, 5, 3]) == [3, 4]

test()

