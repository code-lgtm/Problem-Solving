package com.test;

public class NQueen {
    static int BOARD_SIZE = 8;
    static int QUEEN_CNT = BOARD_SIZE;
    static int[][] board = new int[BOARD_SIZE][BOARD_SIZE];
/*
Output:
Solved
1 0 0 0 0 0 0 0
0 0 0 0 1 0 0 0
0 0 0 0 0 0 0 1
0 0 0 0 0 1 0 0
0 0 1 0 0 0 0 0
0 0 0 0 0 0 1 0
0 1 0 0 0 0 0 0
0 0 0 1 0 0 0 0
Time Taken: 2
 */
    public static void main(String[] args){
        long timeStart = System.currentTimeMillis();
        if(solveNQueen(0)){
            System.out.println("Solved");
            print();
        }else{
            System.out.println("Cannot Solve");
        }
        System.out.println("Time Taken: "+(System.currentTimeMillis() - timeStart));//time increases exponentially!

    }

    static boolean solveNQueen(int row){

        if(row >= QUEEN_CNT){//required number of queens have already been placed, return true
            return true;
        }

        for(int col = 0; col < BOARD_SIZE; col++){
            //try to place the queen in the given row
            if(isSafe(row, col)){
                board[row][col] = 1;

                if(solveNQueen(row+1)){
                    return true;
                }else{
                    board[row][col] = 0;
                }

            }
        }

        return false;


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


    static boolean print(){
        for(int i = 0; i < BOARD_SIZE; i++){
            for(int j =0; j <BOARD_SIZE; j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
        return true;
    }

}
