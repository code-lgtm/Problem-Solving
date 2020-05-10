# https://www.interviewbit.com/problems/min-steps-in-infinite-grid/
#

# Minimum distance between two points if movement can be done in any direction
# can be arrived considering the maximum of distance between xcoordinates and
# ycoordinates of two points

def coverPoints(self, A, B):
    return sum([max(abs(A[i]-A[i+1]), abs(B[i]-B[i+1])) for i in range(len(A)-1)])

