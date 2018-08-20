# https://www.interviewbit.com/problems/max-sum-contiguous-subarray/
#
# Main Idea : Keep on adding terms starting from index 0 till the time cumulative sum is positive. 
# As long sum is positve it has something to contribute to the overall sum

def maxSubArray(A):
    maxsum = float("-inf")
    currsum = 0
        
    i = 0
    while i < len(A):
        currsum += A[i]
        if currsum > maxsum:
            maxsum = currsum
                
        if currsum < 0:
            currsum = 0
        i += 1
            
    return maxsum

def test():
    assert maxSubArray([-2, 1, -3, 4, -1, 2, 1, -5, 4]) == 6

test()
