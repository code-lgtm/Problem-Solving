import unittest
from classic.nqueens import dfs, isSafe

class TestNQueens(unittest.TestCase):
    def test_board(self):
        # Generate an 8x8 board
        board = [[0]*8 for _ in range(8)]
        dfs(board, 0)
        self.assertTrue(sum([1 if board[i][j] else 0 for i in range(8) for j in range(8) ]) == 8)
        for i in range(8):
            for j in range(8):
                if board[i][j]:
                    self.assertTrue(isSafe(board, i, j))
