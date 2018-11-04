def dfs(board, bcol):
    ''' Try all possible queen placements
    '''
    N = len(board)
    if bcol == N:
        return True 

    for row in range(N):
       if isSafe(board, row, bcol):
           board[row][bcol] = 1
           if dfs(board, bcol+1):
               return True
           else:
               board[row][bcol] = 0
    return False

def isSafe(board, i, j):
    ''' Is queen safe at position (i, j)
    '''
    N = len(board)
    for column in range(N):
        if j != column and board[i][column]:
            return False
    
    for row in range(N):
        if i != row and board[row][j]:
            return False

    for dindex in range(1, N):
        if (i-dindex>=0) and (j-dindex>=0):
            if board[i-dindex][j-dindex]:
                return False

        if (i+dindex<N) and (j+dindex<N):
            if board[i+dindex][j+dindex]:
                return False

        if (i-dindex>=0) and (j+dindex<N):
            if board[i-dindex][j+dindex]:
                return False
          
        if (i+dindex<N) and (j-dindex>=0):
            if board[i+dindex][j-dindex]:
                return False
    return True
