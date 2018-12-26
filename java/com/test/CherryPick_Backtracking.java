package com.test;

public class CherryPick_Backtracking {

    //https://leetcode.com/problems/cherry-pickup/
    public static void main(String[] args){
        int[][] maze = {
                {1,1,1,1,1},
                {1,0,1,0,0},
                {1,0,1,0,0},
                {1,1,1,0,0},
                {1,1,1,1,1},
        };

        int[][] aux = new int[maze.length][maze[0].length];
        aux[0][0] = 1;//rat is starting a 0, 0
        int picked =   solveMaze(maze, aux, 0,0);
        System.out.println("Picked : "+picked);

    }

    static int solveMaze(int[][] maze, int[][] aux, int row, int col){

        if(row== maze.length - 1 && col == maze[0].length-1){//solved
            print(aux);
            return maze[row][col];
        }

        int right = Integer.MIN_VALUE, down=Integer.MIN_VALUE;
        if(isValid(maze, row, col+1)){//try going right
            aux[row][col+1] = 1;
            right = solveMaze(maze, aux, row, col+1);
            // return true;
            //}else{
            //     aux[row][col+1] = 0;
            //  }
        }

        if(isValid(maze, row+1, col)){//try going down
            aux[row+1][col] = 1;
            down = solveMaze(maze, aux, row+1, col);
            //   return true;
            //    }else{
            //   aux[row+1][col] = 0;
        }

        if(right > down) {
            aux[row+1][col] = 0;
            return right + maze[row+1][col];
        }else {
            aux[row][col+1] = 0;
            return down + maze[row][col+1];
        }


    }



    static boolean isValid(int[][] maze, int row, int col){
        return ((row <= maze.length-1 && col <= maze[0].length-1)
                && maze[row][col] == 1);
    }

    static boolean print(int[][] sol){
        for(int i = 0; i < sol.length; i++){
            for(int j =0; j <sol[0].length; j++){
                System.out.print(sol[i][j]+" ");
            }
            System.out.println();
        }
        return true;
    }


}
