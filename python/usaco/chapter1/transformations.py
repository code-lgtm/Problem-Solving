"""
ID: kumar.g1
LANG: PYTHON2
TASK: transform 
"""

fin = open ('transform.in', 'r')
fout = open ('transform.out', 'w')


N = int(fin.readline())
input = []
output = []

for i in range(N):
    input.append(fin.readline().rstrip("\n"))

for i in range(N):
    output.append(fin.readline().rstrip("\n"))

def transpose(A):
    l = len(A)
    return [[A[j][i] for j in range(l-1, -1, -1)] for i in range(l)]

def reflection(A):
    l = len(A)
    return [[A[i][j] for j in range(l-1, -1, -1)] for i in range(l)]

def equal(A1, A2): 
    l  = len(A1)
    for i in range(l):
        for j in range(l):
            if A1[i][j] != A2[i][j]:
                return False
    return True

def test():
    A = [[1, 2, 3], [4, 5, 6], [7, 8, 9]]
    assert equal(transpose(A), [[7, 4, 1], [8, 5, 2], [9, 6, 3]]), "Transpose not correct"
    assert equal(reflection(A), [[3, 2, 1], [6, 5, 4], [9, 8, 7]]), "Reflection not correct" 


def checktransform(before, after):
    retval = 7

    # 90 Degree
    transform_90 = transpose(before)
    if equal(transform_90, after):
        return 1

    # 180 Degree
    transform_180 = transpose(transform_90)
    if equal(transform_180, after):
        return 2

    # 270  Degree
    transform_270 = transpose(transform_180)
    if equal(transform_270, after):
        return 3

    # Reflection
    transform_reflect = reflection(before)
    if equal(transform_reflect, after):
        return 4

    # Combination
    transform_reflect_90 = transpose(transform_reflect)
    if equal(transform_reflect_90, after):
        return 5 

    transform_reflect_180 = transpose(transform_reflect_90)
    if equal(transform_reflect_180, after):
        return 5 

    transform_reflect_270 = transpose(transform_reflect_180)
    if equal(transform_reflect_270, after):
        return 5 

    # No Change    
    if equal(before, after):
        return 6

    # InValid Tranform
    return 7

fout.write(str(checktransform(input, output)) + "\n")
fout.close()
