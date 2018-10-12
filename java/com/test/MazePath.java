package com.test;

public class MazePath {
//Find path for the rat to escape the maze
    public static void main(String[] args){

       int[][] maze = {
                {1, 0, 0, 0},
                {1, 1, 1, 0},
                {1, 0, 1, 0},
                {1, 0, 1, 1}
        };



//        int[][] maze =  {
//                {1, 0, 0, 0},
//                {1, 1, 0, 1},
//                {0, 1, 0, 0},
//                {1, 1, 1, 1}
 //   };

        int[][] auxSol = new int[maze.length][maze[0].length];

        boolean pathExists = findPath(maze, auxSol, 0,0);
        if(pathExists){
            System.out.println("Path found: ");
            printPath(auxSol);
        }else{
            System.out.println("No path found!");
        }

/*
Output:

Path found:
1 0 0 0
1 1 1 0
0 0 1 0
0 0 1 1

 */

    }

    private static boolean isValidMove(int x, int y, int[][] maze){

        return x < maze.length && y < maze[0].length && maze[x][y] !=0;

    }

    private static boolean findPath(int[][] maze, int[][] auxSol, int x, int y){


        if(x == maze.length -1 && y == maze[0].length-1){//reached the last point, path found
            auxSol[x][y] = 1;
            return true;
        }


        if(isValidMove(x, y, maze)){

            auxSol[x][y] = 1;

               if(findPath(maze, auxSol, x+1, y)){
                   return true;
               }

               if(findPath(maze, auxSol, x, y+1)){
                   return true;
               }

               //Backtrack
                auxSol[x][y] = 0;
                return false;

        }
        return false;
    }

    private static void printPath(int[][] auxSol){
        for (int i = 0 ; i < auxSol.length; i++){
            for(int j = 0; j < auxSol[0].length; j++){
                System.out.print(auxSol[i][j]+" ");
            }
            System.out.println("");
        }
    }

}
