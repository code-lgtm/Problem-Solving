package com.test;

public class KnightTour_Chess {
/*
Can a Knight cover a chess board exactly ones, while starting from a given point

Output:
Solved, printing
10 1 14 35 40 57 46
13 16 11 38 45 36 41
2 9 0 15 34 39 58
7 12 17 32 37 44 55
18 3 8 51 28 33 48
23 6 21 26 31 50 43
4 19 24 29 52 27 60
 */
    static int BOARD_SIZE = 8; //8x8 chess board
    static int TOTAL_MOVES = 8;// a kinight can have total 8 possible moves
    static int[] xMoves = {-2,-1,1,2,2,1,-1,-2};
    static int[] yMoves = {-1,-2,-2,-1,1,2,2,1};
    static int[][] sol = new int[BOARD_SIZE][BOARD_SIZE];


    public static void main(String[] args){

        for(int i = 0; i < BOARD_SIZE; i++){
            for(int j =0; j <BOARD_SIZE; j++){
                sol[i][j] = -1;//marking unvisited
            }
        }
    int startX = 2, startY = 2;

        //knight will be starting at startX, startY
        sol[startX][startY] = 0;

       if( findPathRec(startX,startY, 0)){
           System.out.println("Solved, printing");
           print();
       }else{
           System.out.println("Solution not possible");
       }

    }

static boolean findPathRec(int curX, int curY, int moveCnt){

        if(solved()){
            return true;
        }

        for(int mov = 0 ; mov < TOTAL_MOVES; mov++){
            int nextX = curX + xMoves[mov];
            int nextY = curY + yMoves[mov];
            if(isNextValid(nextX, nextY)){
                sol[nextX][nextY] = ++moveCnt;//might yield in a solution, mark it
               if( findPathRec(nextX, nextY, moveCnt)){
                   return true;
               }else{
                   --moveCnt;//backtrack
                   sol[nextX][nextY] = -1;//backtrack //the next move will be tried
               }
            }
        }
        return false;




}

    static boolean isNextValid( int nextX, int nextY){//moveNumber 0-> 7, the function tells if a given move is valid or not
            return ((nextX >=0 && nextX <= BOARD_SIZE-1 &&
                    nextY>=0 && nextY<=BOARD_SIZE-1) &&
                    sol[nextX][nextY] == -1);//if next move's coordinates are valid and they are not visited
    }

    static boolean solved(){
        for(int i = 0; i < BOARD_SIZE-1; i++){
            for(int j =0; j <BOARD_SIZE-1; j++){
              if(  sol[i][j] == -1){
                  return false;
              }
            }
        }
        return true;
    }

    static boolean print(){
        for(int i = 0; i < BOARD_SIZE-1; i++){
            for(int j =0; j <BOARD_SIZE-1; j++){
                System.out.print(sol[i][j]+" ");
            }
            System.out.println();
        }
        return true;
    }


}
