package epi.recursion;

//Generate all the non attaching positions of N Queen - Time complexity O(n!)
public class NonAttackingNQueens {
    static int BOARD_SIZE = 4;
    static int QUEEN_CNT = BOARD_SIZE;
    static int[][] board = new int[BOARD_SIZE][BOARD_SIZE];
    /*
    Output:
0 1 0 0
0 0 0 1
1 0 0 0
0 0 1 0

0 0 1 0
1 0 0 0
0 0 0 1
0 1 0 0
     */
    public static void main(String[] args){
        solveNQueen(0);

    }

    static void solveNQueen(int row){

        if(row >= QUEEN_CNT){//required number of queens have already been placed, return true
            print(board);
            System.out.println();
            return;
        }

        for(int col = 0; col < BOARD_SIZE; col++){
            //try to place the queen in the given row
            if(isSafe(row, col)){
                board[row][col] = 1;

                solveNQueen(row+1);
                board[row][col] = 0;//backtrack for the next possible combination
            }
        }



    }

    static boolean isSafe(int x, int y){

        //check row and column
        for(int i = 0; i < BOARD_SIZE; i++){
            if(board[x][i] == 1 || board[i][y] ==1){
                return false;
            }
        }

        //check left diagonal, top left -> bottom right
        int i, j;
        for(  i = x,  j = y; i>= 0 && j >=0; i--, j--){
            if(board[i][j] == 1){
                return false;
            }
        }
        for(  i = x,  j = y; i< BOARD_SIZE && j < BOARD_SIZE; i++, j++){
            if(board[i][j] == 1){
                return false;
            }
        }

        //check right diagonal, top right -> bottom left
        for(i = x, j=y; i< BOARD_SIZE && j >=0; i++, j--){
            if(board[i][j] == 1){
                return false;
            }
        }

        for(i = x, j=y; i >=0 &&j < BOARD_SIZE; i--, j++){
            if(board[i][j] == 1){
                return false;
            }
        }

        return true;
    }


    static void print(int[][] board){
        for(int i = 0; i < BOARD_SIZE; i++){
            for(int j =0; j <BOARD_SIZE; j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }
}
